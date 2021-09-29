package io.github.renestel.anki.provider.proxy.api.dto;

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
public class AnkiRowProxyDto {
    Long id;
    Long noteId;
    String side1;
    String side2;
    List<String> tags;
}
