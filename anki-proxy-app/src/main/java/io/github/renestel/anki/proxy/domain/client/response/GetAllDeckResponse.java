package io.github.renestel.anki.proxy.domain.client.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllDeckResponse {
    Map<String, String> result;
}
