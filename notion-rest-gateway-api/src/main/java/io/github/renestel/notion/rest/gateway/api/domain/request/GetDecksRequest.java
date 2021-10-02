package io.github.renestel.notion.rest.gateway.api.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Schema(title = "Запрос данынх о колодах")
public class GetDecksRequest extends BaseRequest {
    @NotNull
    @Schema(title = "Код провайдера", required = true)
    String provider;
}
