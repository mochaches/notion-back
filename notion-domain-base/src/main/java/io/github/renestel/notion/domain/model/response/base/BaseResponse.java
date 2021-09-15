package io.github.renestel.notion.domain.model.response.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Ответ")
public class BaseResponse<T> {
    @NotNull
    @Schema(title = "Статус ответа")
    private ResponseStatus status = ResponseStatus.OK;

    @Schema(title = "Заголовок (в случае ошибки или предупреждения)")
    private String title;

    @Schema(title = "Сообщение (в случае ошибки или предупреждения)")
    private String message;

    @Schema(title = "Данные")
    private T data;
}
