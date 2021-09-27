package io.github.renestel.anki.proxy.domain.rest.impl;

import io.github.renestel.anki.proxy.domain.client.AnkiApi;
import io.github.renestel.anki.proxy.domain.client.request.GetAllDeckRequest;
import io.github.renestel.anki.proxy.domain.rest.ProviderProxyResponseHandler;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.domain.model.response.base.ResponseStatus;
import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import io.github.renestel.notion.provider.proxy.api.ProxyLogicException;
import io.github.renestel.notion.provider.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.provider.proxy.api.response.GetDecksProxyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j(topic = "ANKI-PROXY-SERVICE")
public class AnkiProxy implements ProviderProxy {
    final AnkiApi ankiApi;
//    final ModelMapper mapper;

    @Override
    public ResponseEntity<BaseResponse<GetDecksProxyResponse>> getDecks(GetDecksProxyRequest request) throws ProxyLogicException {
        var data = ProviderProxyResponseHandler.getResponseData(ankiApi.getAllDecks(new GetAllDeckRequest()));
//        var result = mapper.map(data, GetDecksProxyResponse.class);

        return ResponseEntity.ok(
            BaseResponse.<GetDecksProxyResponse>builder()
                .status(ResponseStatus.OK)
//                .data(result)
                .build()
        );
    }

    @Override
    public String getProviderName() {
        return null;
    }
}
