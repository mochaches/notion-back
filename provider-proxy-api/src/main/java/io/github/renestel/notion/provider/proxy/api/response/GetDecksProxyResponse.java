package io.github.renestel.notion.provider.proxy.api.response;

import io.github.renestel.notion.provider.proxy.api.dto.DeckProxyDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Get decks info")
public class GetDecksProxyResponse {
    @NotNull
    @Schema(title = "Decks list", required = true)
    List<DeckProxyDto> decks;
}
