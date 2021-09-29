package io.github.renestel.anki.provider.proxy.api.response;

import io.github.renestel.anki.provider.proxy.api.dto.AnkiDeckProxyDto;
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
public class GetDecksAnkiProxyResponse {
    List<AnkiDeckProxyDto> decks;
}
