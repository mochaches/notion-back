package io.github.renestel.anki.provider.proxy.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Card info")
public class AnkiCardProxyDto {
    String deckName;
    String front;
    String back;
    Set<String> tags;
}
