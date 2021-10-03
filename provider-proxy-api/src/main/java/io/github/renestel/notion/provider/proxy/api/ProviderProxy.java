package io.github.renestel.notion.provider.proxy.api;

import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.provider.proxy.api.request.AddCardsProxyRequest;
import io.github.renestel.notion.provider.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.provider.proxy.api.request.RemoveCardsProxyRequest;
import io.github.renestel.notion.provider.proxy.api.response.AddCardsProxyResponse;
import io.github.renestel.notion.provider.proxy.api.response.GetDecksProxyResponse;
import org.springframework.http.ResponseEntity;

public interface ProviderProxy {

    ResponseEntity<BaseResponse<GetDecksProxyResponse>> getDecks(GetDecksProxyRequest request) throws ProxyLogicException;

    ResponseEntity<BaseResponse<Void>> removeCards(RemoveCardsProxyRequest request) throws ProxyLogicException;

    ResponseEntity<BaseResponse<AddCardsProxyResponse>> addCards(AddCardsProxyRequest request) throws ProxyLogicException;
}
