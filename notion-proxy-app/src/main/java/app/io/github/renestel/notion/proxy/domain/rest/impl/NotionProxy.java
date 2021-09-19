package app.io.github.renestel.notion.proxy.domain.rest.impl;

import app.io.github.renestel.notion.proxy.client.NotionApi;
import app.io.github.renestel.notion.proxy.client.dto.RowDto;
import app.io.github.renestel.notion.proxy.client.dto.SortDto;
import app.io.github.renestel.notion.proxy.client.request.GetDatabaseInfoRequest;
import app.io.github.renestel.notion.proxy.domain.rest.ProviderProxyResponseHandler;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import io.github.renestel.notion.provider.proxy.api.ProxyLogicException;
import io.github.renestel.notion.provider.proxy.api.dto.DeckProxyDto;
import io.github.renestel.notion.provider.proxy.api.dto.RowProxyDto;
import io.github.renestel.notion.provider.proxy.api.request.GetDeckProxyRequest;
import io.github.renestel.notion.provider.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.provider.proxy.api.response.GetDeckProxyResponse;
import io.github.renestel.notion.provider.proxy.api.response.GetDecksProxyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j(topic = "NOTION-PROXY-SERVICE")
public class NotionProxy implements ProviderProxy {
    final NotionApi notionApi;

    @Override
    public ResponseEntity<BaseResponse<GetDeckProxyResponse>> getDeck(GetDeckProxyRequest request) throws ProxyLogicException {
        var deck = ProviderProxyResponseHandler.getResponseData(notionApi.getDatabase(request));

        System.out.println(deck);
        return null;
    }

    @Override
    public ResponseEntity<BaseResponse<GetDecksProxyResponse>> getDecks(GetDecksProxyRequest request) throws ProxyLogicException {
        var data = ProviderProxyResponseHandler.getResponseData(notionApi.getDatabaseInfo(request.getUser(), request.getDatabase(), GetDatabaseInfoRequest.builder()
            .sorts(Collections.singletonList(SortDto.builder()
                .property("Side1")
                .direction("ascending")
                .build()))
            .build()));
        var deckMaps = data.getRows().stream()
            .collect(Collectors.groupingBy(RowDto::getDeck));

        var decks = deckMaps.keySet().stream()
            .map(e -> {
                var rows = deckMaps.get(e).stream().map(m -> RowProxyDto.builder()
                    .id(m.getId())
                    .side1(m.getSide1())
                    .side2(m.getSide2())
                    .tags(m.getTags())
                    .build()).collect(Collectors.toList());
                return DeckProxyDto.builder()
                    .name(e)
                    .rows(rows)
                    .build();
            }).collect(Collectors.toList());

        return ResponseEntity.ok(
            BaseResponse.<GetDecksProxyResponse>builder()
                .data(GetDecksProxyResponse.builder()
                    .decks(decks)
                    .build())
                .build()
        );
    }

    @Override
    public String getProviderName() {
        return null;
    }
}
