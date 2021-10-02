package io.github.renestel.notion.provider.proxy.api.dto;

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
@Schema(title = "Deck info")
public class NotionDeckProxyDto {
    @Schema(title = "Deck name")
    String name;
    @Schema(title = "Rows")
    List<NotionRowProxyDto> rows;
}
