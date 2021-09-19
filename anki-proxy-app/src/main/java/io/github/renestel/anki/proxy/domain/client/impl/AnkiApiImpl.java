package io.github.renestel.anki.proxy.domain.client.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import io.github.renestel.anki.proxy.domain.client.AnkiApi;
import io.github.renestel.anki.proxy.domain.client.config.AnkiProperties;
import io.github.renestel.anki.proxy.domain.client.request.GetAllDeckRequest;
import io.github.renestel.anki.proxy.domain.client.response.GetAllDeckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilderFactory;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class AnkiApiImpl implements AnkiApi {
    final RestTemplate client;
    final UriBuilderFactory uriBuilderFactory;
    final AnkiProperties props;

    @Override
    public ResponseEntity<GetAllDeckResponse> getAllDecks(GetAllDeckRequest body) {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        var httpEntity = new HttpEntity(body, headers);
        var request = uriBuilderFactory
            .builder()
            .build();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
        client.getMessageConverters().add(0, converter);
        var exchange = client.exchange(
            request,
            HttpMethod.POST,
            httpEntity,
            JsonNode.class
        );
        return null;
    }
}
