package io.github.renestel.anki.proxy.domain.client;

import io.github.renestel.anki.proxy.domain.client.request.FindCardsRequest;
import io.github.renestel.anki.proxy.domain.client.request.GetAllDeckRequest;
import io.github.renestel.anki.proxy.domain.client.request.GetCardsInfoRequest;
import io.github.renestel.anki.proxy.domain.client.response.FindCardsResponse;
import io.github.renestel.anki.proxy.domain.client.response.GetAllDeckResponse;
import io.github.renestel.anki.proxy.domain.client.response.GetCardsInfoResponse;
import org.springframework.http.ResponseEntity;

public interface AnkiApi {

    ResponseEntity<GetAllDeckResponse> getAllDecks(GetAllDeckRequest body);

    ResponseEntity<FindCardsResponse> findCards(FindCardsRequest body);

    ResponseEntity<GetCardsInfoResponse> getCardsInfo(GetCardsInfoRequest body);
}
