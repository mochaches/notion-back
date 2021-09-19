package io.github.renestel.notion.rest.gateway.client;

import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.rest.gateway.api.GatewayRestApi;
import io.github.renestel.notion.rest.gateway.api.domain.request.GetDecksRequest;
import io.github.renestel.notion.rest.gateway.api.domain.response.GetDecksResponse;
import io.github.renestel.notion.rest.gateway.client.config.GatewayRestClientProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilderFactory;

@RequiredArgsConstructor
public class GatewayRestClient implements GatewayRestApi {
    final UriBuilderFactory uriBuilderFactory;
    final GatewayRestClientProperties properties;
    final RestTemplate restTemplate;

    @Override
    public ResponseEntity<BaseResponse<GetDecksResponse>> getDecks(GetDecksRequest request) {
        var parameterizedTypeReference = new ParameterizedTypeReference<BaseResponse<GetDecksResponse>>() {
        };

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var exchange = restTemplate.exchange(
            uriBuilderFactory
                .builder()
                .path(properties.getPaths().getDecks())
                .build(),
            HttpMethod.POST,
            new HttpEntity<>(request, headers),
            parameterizedTypeReference
        );
        return exchange;
    }

//    @Override
//    public ResponseEntity<GetDecksResponse> getDecks(GetDecksRequest request) {
//        var headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        var exchange = restTemplate.exchange(
//            uriBuilderFactory
//                .builder()
//                .path(properties.getPaths().getGetDecks())
//                .build(),
//            HttpMethod.POST,
//            new HttpEntity<>(request, headers),
//            GetDecksResponse.class
//        );
//        return exchange;
//    }
}
