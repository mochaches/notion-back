package io.github.renestel.notion.provider.proxy.api.request;

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
@Schema(title = "Remove cards")
public class RemoveCardsProxyRequest {
    List<String> cardIds;
}
