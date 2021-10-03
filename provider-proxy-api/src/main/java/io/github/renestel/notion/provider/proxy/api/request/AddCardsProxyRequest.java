package io.github.renestel.notion.provider.proxy.api.request;

import io.github.renestel.notion.provider.proxy.api.dto.DeckProxyDto;
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
@Schema(title = "Get decks info")
public class AddCardsProxyRequest {
    List<DeckProxyDto> decks;
}
