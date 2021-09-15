package io.github.renestel.notion.back.app.domain.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Deck info")
public class DeckDto {
    @Schema(title = "Deck id")
    Long id;
    @Schema(title = "Deck name")
    String name;
}
