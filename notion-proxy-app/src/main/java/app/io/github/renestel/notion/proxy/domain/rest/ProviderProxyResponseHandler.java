package app.io.github.renestel.notion.proxy.domain.rest;

import io.github.renestel.notion.provider.proxy.api.ProxyLogicException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProviderProxyResponseHandler {

    public static <T> T getResponseData(ResponseEntity<T> response) throws ProxyLogicException {
        if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
            throw new ProxyLogicException("Incorrect response code or data is empty.");
        }

        return response.getBody();
    }
}
