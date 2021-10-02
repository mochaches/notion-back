package io.github.renestel.notion.back.app.rest;

import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.persistence.entity.NoteEntity;
import io.github.renestel.notion.persistence.repository.NoteRepository;
import io.github.renestel.notion.rest.gateway.api.domain.request.GetDecksRequest;
import io.github.renestel.notion.rest.gateway.api.domain.response.GetDecksResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class NotesController {

    final NoteRepository noteRepository;

    @PostMapping("/removeCards")
    @Operation(tags = "Deck", summary = "NOTION_REMOVE_CARDS_REQUEST", description = "Удаление карт")
    public ResponseEntity<BaseResponse<GetDecksResponse>> removeCards(@Valid @RequestBody GetDecksRequest request) {
        return null;
    }

    @PostMapping("/createCards")
    @Operation(tags = "Deck", summary = "NOTION_CREATE_CARDS_REQUEST", description = "Создание карт")
    public ResponseEntity<BaseResponse<GetDecksResponse>> createCards(@Valid @RequestBody GetDecksRequest request) {
        return null;
    }

}
