package io.github.renestel.anki.provider.proxy.api.request;

import io.github.renestel.anki.provider.proxy.api.dto.AnkiCardProxyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddCardsRequest {
    List<AnkiCardProxyDto> cards;
}
