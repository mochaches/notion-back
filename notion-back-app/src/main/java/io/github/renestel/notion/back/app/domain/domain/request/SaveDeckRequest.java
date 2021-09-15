package io.github.renestel.notion.back.app.domain.domain.request;

import io.github.renestel.notion.back.app.domain.domain.dto.DeckDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Save deck request")
public class SaveDeckRequest {
    DeckDto deck;
}
