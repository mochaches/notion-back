package io.github.renestel.notion.back.app.domain.service.impl;

import io.github.renestel.notion.back.app.domain.service.DeckService;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.domain.model.response.base.ResponseStatus;
import io.github.renestel.notion.persistence.repository.DeckRepository;
import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import io.github.renestel.notion.provider.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.provider.proxy.client.utils.ProviderProxyResponseHandler;
import io.github.renestel.notion.rest.gateway.api.domain.dto.DeckDto;
import io.github.renestel.notion.rest.gateway.api.domain.dto.RowDto;
import io.github.renestel.notion.rest.gateway.api.domain.request.GetDecksRequest;
import io.github.renestel.notion.rest.gateway.api.domain.response.GetDecksResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "NOTION-DECK-SERVICE")
public class DeckServiceImpl implements DeckService {

    final DeckRepository repository;
    final ModelMapper mapper;
    final List<ProviderProxy> proxiesList;

    Map<String, ProviderProxy> proxies;

    @PostConstruct
    private void postConstruct() {
        proxies = proxiesList.stream().collect(Collectors.toMap(ProviderProxy::getProviderName, Function.identity()));
    }

    @Override
    @SneakyThrows
    public ResponseEntity<BaseResponse<GetDecksResponse>> getDecks(GetDecksRequest request) {
        var notion = proxies.get("notion").getDecks(GetDecksProxyRequest.builder()
            .database(request.getDatabase())
            .user(request.getUser())
            .build());
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
}
