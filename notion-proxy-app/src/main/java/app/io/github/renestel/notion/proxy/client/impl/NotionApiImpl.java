package app.io.github.renestel.notion.proxy.client.impl;

import app.io.github.renestel.notion.proxy.client.NotionApi;
import app.io.github.renestel.notion.proxy.client.config.NotionProperties;
import app.io.github.renestel.notion.proxy.client.request.GetDatabaseInfoRequest;
import app.io.github.renestel.notion.proxy.client.response.GetDatabaseInfoResponse;
import app.io.github.renestel.notion.proxy.client.response.GetDatabaseResponse;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.renestel.notion.provider.proxy.api.request.GetDeckProxyRequest;
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
    public ResponseEntity<GetDatabaseResponse> getDatabase(GetDeckProxyRequest body) {
        var headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + body.getUser());
        headers.set("Notion-Version", "2021-05-13");
        var httpEntity = new HttpEntity(headers);
        var request = uriBuilderFactory
                .builder()
                .path(props.getPaths().getDatabases())
                .build(body.getDatabase());
        var exchange = client.exchange(
                request,
                HttpMethod.GET,
                httpEntity,
                GetDatabaseResponse.class
        );
        return exchange;
    }

    @Override
    public ResponseEntity<GetDatabaseInfoResponse> getDatabaseInfo(String token, String database, GetDatabaseInfoRequest body) {
        var headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.set("Notion-Version", "2021-05-13");
        var httpEntity = new HttpEntity(headers);
        var request = uriBuilderFactory
                .builder()
                .path(props.getPaths().getQueryDatabases())
                .build(database);
        var exchange = client.exchange(
                request,
                HttpMethod.POST,
                httpEntity,
                GetDatabaseInfoResponse.class
        );
        return exchange;
    }
}
