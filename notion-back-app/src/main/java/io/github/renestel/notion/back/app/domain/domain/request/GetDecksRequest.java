package io.github.renestel.notion.back.app.domain.domain.request;

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
@Schema(title = "Get deck request")
public class GetDecksRequest {
    @NotNull
    String database;
    @NotNull
    String user;
}

