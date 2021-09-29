package io.github.renestel.notion.rest.gateway.api.domain.dto;

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
@Schema(title = "Row info")
public class RowDto {
    @Schema(title = "Unique row id")
    Long id;
    @Schema(title = "Question")
    String side1;
    @Schema(title = "Answer")
    String side2;
    @Schema(title = "Tags")
    List<String> tags;
}
