package io.github.renestel.notion.rest.gateway.api;

import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.rest.gateway.api.domain.request.GetDecksRequest;
import io.github.renestel.notion.rest.gateway.api.domain.response.GetDecksResponse;
import org.springframework.http.ResponseEntity;

public interface GatewayRestApi {

    ResponseEntity<BaseResponse<GetDecksResponse>> getDecks(GetDecksRequest request);
}
