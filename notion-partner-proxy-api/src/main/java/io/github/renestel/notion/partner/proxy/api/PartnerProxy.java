package io.github.renestel.notion.partner.proxy.api;

import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.partner.proxy.api.request.GetDeckProxyRequest;
import io.github.renestel.notion.partner.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.partner.proxy.api.response.GetDeckProxyResponse;
import io.github.renestel.notion.partner.proxy.api.response.GetDecksProxyResponse;
import org.springframework.http.ResponseEntity;

public interface PartnerProxy {
    ResponseEntity<BaseResponse<GetDecksProxyResponse>> getDecks(GetDecksProxyRequest request) throws ProxyLogicException;

    ResponseEntity<BaseResponse<GetDeckProxyResponse>> getDeck(GetDeckProxyRequest request) throws ProxyLogicException;
}
