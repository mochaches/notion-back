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
public class TitleDto {
    String id;
    String name;
    TypeEnum type;
    List<TagDto> tags;
}
