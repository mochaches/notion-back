package app.io.github.renestel.notion.proxy.client.impl;

import app.io.github.renestel.notion.proxy.client.NotionApi;
import app.io.github.renestel.notion.proxy.client.config.NotionProperties;
import app.io.github.renestel.notion.proxy.client.request.GetDeckRequest;
import app.io.github.renestel.notion.proxy.client.response.GetDeckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilderFactory;

@Component
@RequiredArgsConstructor
public class NotionApiImpl implements NotionApi {

     final RestTemplate client;
     final UriBuilderFactory uriBuilderFactory;
     final NotionProperties props;

    @Override
    public ResponseEntity<GetDeckResponse> getVendors(GetDeckRequest body) {
        var headers = new HttpHeaders();
//        headers.set(AUTHORIZATION, "Bearer " + header);
        var httpEntity = new HttpEntity(headers);
        var request = uriBuilderFactory
                .builder()
                .path(props.getPaths().getDeck())
                .build();
        var exchange = client.exchange(
                request,
                HttpMethod.GET,
                httpEntity,
                GetDeckResponse.class
        );
        return exchange;
    }
}
