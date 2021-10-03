package io.github.renestel.notion.rest.gateway.client.utils;

import io.github.renestel.notion.domain.model.base.ErrorCode;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.domain.model.response.base.ResponseStatus;
import io.github.renestel.notion.rest.gateway.api.GatewayLogicException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GatewayResponseHandler {
    public static <T> T getResponse(ResponseEntity<BaseResponse<T>> responseEntity) throws GatewayLogicException {

        if (responseEntity.getStatusCode() != HttpStatus.OK)
            throw new GatewayLogicException("Request status is not succeed.");

        var body = responseEntity.getBody();

        if (body == null)
            throw new GatewayLogicException("Response entity hasn't body");

        if (body.getStatus() != ResponseStatus.OK)
            throw new GatewayLogicException(
                String.format(
                    "Request status is not succeed [%s][%s:%s].",
                    body.getStatus(),
                    body.getTitle(),
                    body.getMessage()
                ),
                ErrorCode.from(body.getTitle())
            );

        return body.getData();
    }
}
