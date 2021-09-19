package io.github.renestel.notion.back.app.domain.domain.response;

import io.github.renestel.notion.back.app.domain.domain.dto.DeckDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Deck response")
public class GetDecksResponse {
    List<DeckDto> decks;
}