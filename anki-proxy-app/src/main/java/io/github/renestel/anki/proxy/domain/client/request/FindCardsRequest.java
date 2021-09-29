package io.github.renestel.anki.proxy.domain.client.request;

import io.github.renestel.anki.proxy.domain.client.dto.FindCardsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindCardsRequest {
    String action ;
    Integer version ;
    FindCardsDto params;
}
