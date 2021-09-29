package io.github.renestel.anki.provider.proxy.api;

import io.github.renestel.anki.provider.proxy.api.response.GetDecksAnkiProxyResponse;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface AnkiProxy {

    ResponseEntity<BaseResponse<GetDecksAnkiProxyResponse>> getDecks();
}
