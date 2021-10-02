package io.github.renestel.notion.rest.gateway.api.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Valid
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest {
    @NotNull
    @Schema(title = "Уникальный идентификатор пользователя", required = true)
    Long user;
}
