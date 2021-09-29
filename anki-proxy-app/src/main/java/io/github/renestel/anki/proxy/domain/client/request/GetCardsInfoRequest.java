package io.github.renestel.anki.proxy.domain.client.request;

import io.github.renestel.anki.proxy.domain.client.dto.ParamsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCardsInfoRequest {
    String action;
    Integer version;
    ParamsDto params;
}
