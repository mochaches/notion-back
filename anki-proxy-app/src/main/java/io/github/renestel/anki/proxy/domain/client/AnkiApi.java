package io.github.renestel.anki.proxy.domain.client;

import io.github.renestel.anki.proxy.domain.client.request.GetAllDeckRequest;
import io.github.renestel.anki.proxy.domain.client.response.GetAllDeckResponse;
import org.springframework.http.ResponseEntity;

public interface AnkiApi {

    ResponseEntity<GetAllDeckResponse> getAllDecks(GetAllDeckRequest body);
}
