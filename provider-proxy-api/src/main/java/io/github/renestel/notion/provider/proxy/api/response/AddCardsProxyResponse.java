package io.github.renestel.notion.provider.proxy.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Add cards info")
public class AddCardsProxyResponse {
    @NotNull
    @Schema(title = "Cards ids", required = true)
    List<String> cardIds;
}
