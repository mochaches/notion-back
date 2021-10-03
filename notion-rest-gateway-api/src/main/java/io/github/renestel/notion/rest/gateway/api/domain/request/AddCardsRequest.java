package io.github.renestel.notion.rest.gateway.api.domain.request;

import io.github.renestel.notion.rest.gateway.api.domain.dto.DeckDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Schema(title = "Запрос данынх о колодах")
public class AddCardsRequest extends BaseRequest {
    @NotNull
    @Schema(title = "Код провайдера", required = true)
    String provider;
    List<DeckDto> decks;
}
