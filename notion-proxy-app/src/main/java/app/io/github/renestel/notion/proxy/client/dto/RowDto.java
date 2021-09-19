package app.io.github.renestel.notion.proxy.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RowDto {
    String id;
    String side1;
    String side2;
    List<String> tags;
    String deck;
}
