package io.github.renestel.notion.rest.gateway.api;

import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.rest.gateway.api.domain.request.AddCardsRequest;
import io.github.renestel.notion.rest.gateway.api.domain.request.GetDecksRequest;
import io.github.renestel.notion.rest.gateway.api.domain.request.RemoveCardsRequest;
import io.github.renestel.notion.rest.gateway.api.domain.response.AddCardsResponse;
import io.github.renestel.notion.rest.gateway.api.domain.response.GetDecksResponse;
import org.springframework.http.ResponseEntity;

public interface GatewayRestApi {

    ResponseEntity<BaseResponse<GetDecksResponse>> getDecks(GetDecksRequest request);

    ResponseEntity<BaseResponse<AddCardsResponse>> addCards(AddCardsRequest request);

    ResponseEntity<BaseResponse<Void>> removeDecks(RemoveCardsRequest request);
}
