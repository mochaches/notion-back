package io.github.renestel.notion.back.app.domain.service.impl;

import io.github.renestel.notion.back.app.domain.service.DeckService;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.domain.model.response.base.ResponseStatus;
import io.github.renestel.notion.persistence.repository.UserRepository;
import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import io.github.renestel.notion.provider.proxy.api.dto.DeckProxyDto;
import io.github.renestel.notion.provider.proxy.api.dto.RowProxyDto;
import io.github.renestel.notion.provider.proxy.api.request.AddCardsProxyRequest;
import io.github.renestel.notion.provider.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.provider.proxy.api.request.RemoveCardsProxyRequest;
import io.github.renestel.notion.provider.proxy.client.utils.ProviderProxyResponseHandler;
import io.github.renestel.notion.rest.gateway.api.domain.dto.DeckDto;
import io.github.renestel.notion.rest.gateway.api.domain.dto.RowDto;
import io.github.renestel.notion.rest.gateway.api.domain.request.AddCardsRequest;
import io.github.renestel.notion.rest.gateway.api.domain.request.GetDecksRequest;
import io.github.renestel.notion.rest.gateway.api.domain.request.RemoveCardsRequest;
import io.github.renestel.notion.rest.gateway.api.domain.response.AddCardsResponse;
import io.github.renestel.notion.rest.gateway.api.domain.response.GetDecksResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "NOTION-DECK-SERVICE")
public class DeckServiceImpl implements DeckService {
    final UserRepository userRepository;
    final ModelMapper mapper;
    final Map<String, ProviderProxy> proxies;

    @Override
    @SneakyThrows
    @Transactional
    public ResponseEntity<BaseResponse<GetDecksResponse>> getDecks(GetDecksRequest request) {
        var user = userRepository.getById(request.getUser());
        var argument = GetDecksProxyRequest.builder()
            .database(user.getTable())
            .user(user.getToken())
            .build();
        var notion = proxies.get(request.getProvider()).getDecks(argument);
//        var notion = proxies.get(request.getProvider()).getDecks(GetDecksProxyRequest.builder()
////            .database(request.getDatabase())
//            .user(request.getUser())
//            .build());
        var response = ProviderProxyResponseHandler.getResponse(notion);
        var result = response.getDecks().stream()
            .map(e -> {
                return DeckDto.builder()
                    .name(e.getName())
                    .rows(e.getRows().stream()
                        .map(r -> {
                            return RowDto.builder()
                                .id(r.getId())
                                .side1(r.getSide1())
                                .side2(r.getSide2())
                                .tags(r.getTags())
                                .build();
                        })
                        .collect(Collectors.toList()))
                    .build();
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(
            BaseResponse
                .<GetDecksResponse>builder()
                .status(ResponseStatus.OK)
                .data(GetDecksResponse.builder()
                    .decks(result)
                    .build())
                .build());
    }

    @Override
    @SneakyThrows
    public ResponseEntity<BaseResponse<Void>> removeCards(RemoveCardsRequest request) {
        var query = RemoveCardsProxyRequest.builder()
            .cardIds(request.getCardIds())
            .build();
        proxies.get(request.getProvider()).removeCards(query);
        return ResponseEntity.ok(
            BaseResponse
                .<Void>builder()
                .status(ResponseStatus.OK)
                .build());
    }

    @Override
    @SneakyThrows
    public ResponseEntity<BaseResponse<AddCardsResponse>> addCards(AddCardsRequest request) {
        var decks = request.getDecks().stream()
            .map(e -> {
                return DeckProxyDto.builder()
                    .name(e.getName())
                    .rows(e.getRows().stream().map(c -> {
                        return RowProxyDto.builder()
                            .id(c.getId())
                            .side1(c.getSide1())
                            .side2(c.getSide2())
                            .tags(c.getTags())
                            .build();
                    }).collect(Collectors.toList()))
                    .build();
            }).collect(Collectors.toList());
        var query = AddCardsProxyRequest.builder()
            .decks(decks)
            .build();
        var response = ProviderProxyResponseHandler.getResponse(proxies.get(request.getProvider()).addCards(query));
        return ResponseEntity.ok(
            BaseResponse
                .<AddCardsResponse>builder()
                .status(ResponseStatus.OK)
                .data(AddCardsResponse.builder()
                    .cardIds(response.getCardIds())
                    .build())
                .build());
    }
}
