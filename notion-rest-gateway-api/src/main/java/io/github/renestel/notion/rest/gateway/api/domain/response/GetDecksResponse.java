package io.github.renestel.notion.rest.gateway.api.domain.response;

import io.github.renestel.notion.rest.gateway.api.domain.dto.DeckDto;
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
@Schema(title = "Информация о колодах")
public class GetDecksResponse {
    List<DeckDto> decks;
}
