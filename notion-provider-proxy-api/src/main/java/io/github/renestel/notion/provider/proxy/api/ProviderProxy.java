package io.github.renestel.notion.provider.proxy.api;

import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.provider.proxy.api.request.GetDeckProxyRequest;
import io.github.renestel.notion.provider.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.provider.proxy.api.response.GetDeckProxyResponse;
import io.github.renestel.notion.provider.proxy.api.response.GetDecksProxyResponse;
import org.springframework.http.ResponseEntity;

public interface ProviderProxy {
    ResponseEntity<BaseResponse<GetDeckProxyResponse>> getDeck(GetDeckProxyRequest request) throws ProxyLogicException;

    ResponseEntity<BaseResponse<GetDecksProxyResponse>> getDecks(GetDecksProxyRequest request) throws ProxyLogicException;
}
