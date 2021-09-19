package io.github.renestel.notion.provider.proxy.api.request;

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
@Schema(title = "Get deck info")
public class GetDeckProxyRequest {
    @NotNull
    @Schema(title = "Database id", required = true)
    String database;
    @NotNull
    @Schema(title = "User token", required = true)
    String user;
}
