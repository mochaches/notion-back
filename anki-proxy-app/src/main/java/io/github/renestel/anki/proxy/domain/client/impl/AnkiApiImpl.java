package io.github.renestel.anki.proxy.domain.client.impl;

import io.github.renestel.anki.proxy.domain.client.AnkiApi;
import io.github.renestel.anki.proxy.domain.client.config.AnkiProperties;
import io.github.renestel.anki.proxy.domain.client.request.FindCardsRequest;
import io.github.renestel.anki.proxy.domain.client.request.GetAllDeckRequest;
import io.github.renestel.anki.proxy.domain.client.request.GetCardsInfoRequest;
import io.github.renestel.anki.proxy.domain.client.response.FindCardsResponse;
import io.github.renestel.anki.proxy.domain.client.response.GetAllDeckResponse;
import io.github.renestel.anki.proxy.domain.client.response.GetCardsInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilderFactory;

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
        var exchange = client.exchange(
            request,
            HttpMethod.POST,
            httpEntity,
            GetAllDeckResponse.class
        );
        return exchange;
    }

    @Override
    public ResponseEntity<FindCardsResponse> findCards(FindCardsRequest body) {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        var httpEntity = new HttpEntity(body, headers);
        var request = uriBuilderFactory
            .builder()
            .build();
        var exchange = client.exchange(
            request,
            HttpMethod.POST,
            httpEntity,
            FindCardsResponse.class
        );
        return exchange;
    }

    @Override
    public ResponseEntity<GetCardsInfoResponse> getCardsInfo(GetCardsInfoRequest body) {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        var httpEntity = new HttpEntity(body, headers);
        var request = uriBuilderFactory
            .builder()
            .build();
        var exchange = client.exchange(
            request,
            HttpMethod.POST,
            httpEntity,
            GetCardsInfoResponse.class
        );
        return exchange;
    }
}
