package io.github.renestel.anki.proxy.domain.client.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllDeckRequest {
    String action = "deckNamesAndIds";
    Integer version = 6;
}
