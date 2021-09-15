package io.github.renestel.notion.partner.proxy.api.request;

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
@Schema(title = "Get decks info")
public class GetDecksProxyRequest {
    @NotNull
    @Schema(title = "User id", required = true)
    String userId;
}
