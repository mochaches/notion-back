package io.github.renestel.notion.back.app.domain.service;

import io.github.renestel.notion.back.app.domain.domain.request.GetDeckRequest;
import io.github.renestel.notion.back.app.domain.domain.request.SaveDeckRequest;
import io.github.renestel.notion.back.app.domain.domain.response.GetDeckResponse;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface DeckService {
    ResponseEntity<BaseResponse<GetDeckResponse>> getDeck(GetDeckRequest request);

    ResponseEntity<BaseResponse<Void>> saveDeck(SaveDeckRequest request);
}
