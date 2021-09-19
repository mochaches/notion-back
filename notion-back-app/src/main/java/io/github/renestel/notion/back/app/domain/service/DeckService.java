package io.github.renestel.notion.back.app.domain.service;

import io.github.renestel.notion.back.app.domain.domain.request.GetDecksRequest;
import io.github.renestel.notion.back.app.domain.domain.request.SaveDeckRequest;
import io.github.renestel.notion.back.app.domain.domain.response.GetDecksResponse;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface DeckService {
    ResponseEntity<BaseResponse<GetDecksResponse>> getDecks(GetDecksRequest request);

    ResponseEntity<BaseResponse<Void>> saveDeck(SaveDeckRequest request);
}
