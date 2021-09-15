package io.github.renestel.notion.partner.proxy.client;

import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.partner.proxy.api.PartnerProxy;
import io.github.renestel.notion.partner.proxy.api.ProxyLogicException;
import io.github.renestel.notion.partner.proxy.api.request.GetDeckProxyRequest;
import io.github.renestel.notion.partner.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.partner.proxy.api.response.GetDeckProxyResponse;
import io.github.renestel.notion.partner.proxy.api.response.GetDecksProxyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class PartnerProxyClient implements PartnerProxy {
    @Override
    public ResponseEntity<BaseResponse<GetDecksProxyResponse>> getDecks(GetDecksProxyRequest request) throws ProxyLogicException {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponse<GetDeckProxyResponse>> getDeck(GetDeckProxyRequest request) throws ProxyLogicException {
        return null;
    }
}
