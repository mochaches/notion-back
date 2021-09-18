package io.github.renestel.notion.back.app.domain.service.impl;

import io.github.renestel.notion.back.app.domain.domain.dto.DeckDto;
import io.github.renestel.notion.back.app.domain.domain.request.GetDeckRequest;
import io.github.renestel.notion.back.app.domain.domain.request.SaveDeckRequest;
import io.github.renestel.notion.back.app.domain.domain.response.GetDeckResponse;
import io.github.renestel.notion.back.app.domain.service.DeckService;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.domain.model.response.base.ResponseStatus;
import io.github.renestel.notion.persistence.repository.DecksRepository;
import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import io.github.renestel.notion.provider.proxy.api.request.GetDeckProxyRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "NOTION-DECK-SERVICE")
public class DeckServiceImpl implements DeckService {

    final DecksRepository repository;
    final ModelMapper mapper;
    final List<ProviderProxy> proxiesList;

    Map<String, ProviderProxy> proxies;

    @PostConstruct
    private void postConstruct() {
        proxies = proxiesList.stream().collect(Collectors.toMap(ProviderProxy::getProviderName, Function.identity()));
    }

    @Override
    @SneakyThrows
    public ResponseEntity<BaseResponse<GetDeckResponse>> getDeck(GetDeckRequest request) {
        proxies.get("notion").getDeck(GetDeckProxyRequest.builder().build());
        return ResponseEntity.ok(
            BaseResponse
                .<GetDeckResponse>builder()
                .status(ResponseStatus.OK)
                .data(GetDeckResponse.builder()
                    .deck(null)
                    .build())
                .build());
    }

    @Override
    public ResponseEntity<BaseResponse<Void>> saveDeck(SaveDeckRequest request) {
        return null;
    }

}
