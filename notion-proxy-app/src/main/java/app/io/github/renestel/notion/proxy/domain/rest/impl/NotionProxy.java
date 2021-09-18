package app.io.github.renestel.notion.proxy.domain.rest.impl;

import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import io.github.renestel.notion.provider.proxy.api.ProxyLogicException;
import io.github.renestel.notion.provider.proxy.api.request.GetDeckProxyRequest;
import io.github.renestel.notion.provider.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.provider.proxy.api.response.GetDeckProxyResponse;
import io.github.renestel.notion.provider.proxy.api.response.GetDecksProxyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j(topic = "NOTION-PROXY-SERVICE")
public class NotionProxy implements ProviderProxy {
    @Override
    public ResponseEntity<BaseResponse<GetDeckProxyResponse>> getDeck(GetDeckProxyRequest request) throws ProxyLogicException {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponse<GetDecksProxyResponse>> getDecks(GetDecksProxyRequest request) throws ProxyLogicException {
        return null;
    }

    @Override
    public String getProviderName() {
        return null;
    }
}
