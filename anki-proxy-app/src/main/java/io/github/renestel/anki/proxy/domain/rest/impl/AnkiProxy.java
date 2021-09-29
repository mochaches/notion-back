package io.github.renestel.anki.proxy.domain.rest.impl;

import io.github.renestel.anki.proxy.domain.client.AnkiApi;
import io.github.renestel.anki.proxy.domain.client.dto.FindCardsDto;
import io.github.renestel.anki.proxy.domain.client.dto.ParamsDto;
import io.github.renestel.anki.proxy.domain.client.request.FindCardsRequest;
import io.github.renestel.anki.proxy.domain.client.request.GetAllDeckRequest;
import io.github.renestel.anki.proxy.domain.client.request.GetCardsInfoRequest;
import io.github.renestel.anki.proxy.domain.client.response.GetCardsInfoResponse;
import io.github.renestel.anki.proxy.domain.rest.ProviderProxyResponseHandler;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.domain.model.response.base.ResponseStatus;
import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import io.github.renestel.notion.provider.proxy.api.ProxyLogicException;
import io.github.renestel.notion.provider.proxy.api.dto.DeckProxyDto;
import io.github.renestel.notion.provider.proxy.api.dto.RowProxyDto;
import io.github.renestel.notion.provider.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.provider.proxy.api.response.GetDecksProxyResponse;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j(topic = "ANKI-PROXY-SERVICE")
public class AnkiProxy implements ProviderProxy {
    final AnkiApi ankiApi;
//    final ModelMapper mapper;

    @Override
    public ResponseEntity<BaseResponse<GetDecksProxyResponse>> getDecks(GetDecksProxyRequest request) throws ProxyLogicException {
        var data = ProviderProxyResponseHandler.getResponseData(ankiApi.getAllDecks(new GetAllDeckRequest()));
        var decksIds = data.getResult().keySet();
//
        var cardsIds = decksIds.stream()
            .flatMap(e -> {
                var findCards = ankiApi.findCards(FindCardsRequest.builder()
                    .action("findCards")
                    .version(6)
                    .params(FindCardsDto.builder()
                        .query("deck:" + e)
                        .build())
                    .build());
                var cardIds = Try.of(() -> ProviderProxyResponseHandler.getResponseData(findCards)).get().getResult();
                return cardIds.stream();
            }).collect(Collectors.toList());

        var result = cardsIds.stream()
            .map(e -> {
                return Try.of(() -> ProviderProxyResponseHandler.getResponseData(ankiApi.getCardsInfo(GetCardsInfoRequest.builder()
                        .action("cardsInfo")
                        .version(6)
                        .params(ParamsDto.builder()
                            .cards(List.of(Long.parseLong(e)))
                            .build())
                        .build())))
                    .get();
            }).collect(Collectors.toList());
        var collect = result.stream()
            .collect(Collectors.groupingBy(GetCardsInfoResponse::getDeckName));
        var decks = collect.keySet().stream()
            .map(e -> {
                var getCardsInfoResponses = collect.get(e);
                var rows = getCardsInfoResponses.stream()
                    .map(c -> {
                        return RowProxyDto.builder()
                            .id(c.getCardId())
                            .noteId(c.getNoteId())
                            .side1(c.getFront())
                            .side2(c.getBack())
                            .build();
                    }).collect(Collectors.toList());
                return DeckProxyDto.builder()
                    .name(e)
                    .rows(rows)
                    .build();

            }).collect(Collectors.toList());

        return ResponseEntity.ok(
            BaseResponse.<GetDecksProxyResponse>builder()
                .status(ResponseStatus.OK)
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
