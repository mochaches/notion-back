package io.github.renestel.notion.provider.proxy.client;

import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import io.github.renestel.notion.provider.proxy.api.ProxyLogicException;
import io.github.renestel.notion.provider.proxy.api.request.GetDeckProxyRequest;
import io.github.renestel.notion.provider.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.provider.proxy.api.response.GetDeckProxyResponse;
import io.github.renestel.notion.provider.proxy.api.response.GetDecksProxyResponse;
import io.github.renestel.notion.provider.proxy.client.config.ProviderProxyProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilderFactory;

import java.util.Map;

@RequiredArgsConstructor
public class ProviderProxyClient implements ProviderProxy {
    static final String PARTNER_OPTION = "partner";

    final UriBuilderFactory uriBuilderFactory;
    final ProviderProxyProperties props;
    final RestTemplate restTemplate;
    final String partnerName;

    @Override
    public ResponseEntity<BaseResponse<GetDeckProxyResponse>> getDeck(GetDeckProxyRequest request) throws ProxyLogicException {
        var parameterizedTypeReference = new ParameterizedTypeReference<BaseResponse<GetDeckProxyResponse>>() {
        };

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var exchange = restTemplate.exchange(
            uriBuilderFactory
                .builder()
                .path(props.getPaths().getGetDeck())
                .build(Map.of(PARTNER_OPTION, partnerName.toLowerCase())),
            HttpMethod.POST,
            new HttpEntity<>(request, headers),
            parameterizedTypeReference
        );
        return exchange;
    }

    @Override
    public ResponseEntity<BaseResponse<GetDecksProxyResponse>> getDecks(GetDecksProxyRequest request) throws ProxyLogicException {
        var parameterizedTypeReference = new ParameterizedTypeReference<BaseResponse<GetDecksProxyResponse>>() {
        };

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var exchange = restTemplate.exchange(
            uriBuilderFactory
                .builder()
                .path(props.getPaths().getGetDecks())
                .build(Map.of(PARTNER_OPTION, partnerName.toLowerCase())),
            HttpMethod.POST,
            new HttpEntity<>(request, headers),
            parameterizedTypeReference
        );
        return exchange;
    }

    @Override
    public String getProviderName() {
        return partnerName.toLowerCase();
    }
}
