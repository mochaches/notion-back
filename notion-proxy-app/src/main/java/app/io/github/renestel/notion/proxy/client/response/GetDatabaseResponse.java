package app.io.github.renestel.notion.proxy.client.response;

import app.io.github.renestel.notion.proxy.client.dto.TagDto;
import app.io.github.renestel.notion.proxy.client.dto.TitleDto;
import app.io.github.renestel.notion.proxy.client.dto.TypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetDatabaseResponse {
    @JsonIgnore
    List<TitleDto> properties;

    @JsonProperty("properties")
    private void unpackNestedProperties(Map<String, Object> properties) {
        this.properties = properties.entrySet().stream()
                .map(e -> {
                    var stringObjectMap = toMap(e.getValue());
                    var name = (String) stringObjectMap.get("name");
                    var id = (String) stringObjectMap.get("id");
                    var type = (String) stringObjectMap.get("type");
                    var tags = toList(toMap(stringObjectMap.get("multi_select")).get("options")).stream()
                            .map(a -> {
                                var tagId = (String) a.get("id");
                                var tagName = (String) a.get("name");
                                var tagColor = (String) a.get("color");

                                return TagDto.builder()
                                        .id(tagId)
                                        .name(tagName)
                                        .color(tagColor)
                                        .build();
                            })
                            .collect(Collectors.toList());

                    var build = TitleDto.builder()
                            .id(id)
                            .name(name)
                            .type(TypeEnum.valueOf(type.toUpperCase()))
                            .tags(tags)
                            .build();
                    return build;
                }).collect(Collectors.toList());
    }

    static List<Map<String, Object>> toList(Object source) {
        if (source == null) {
            return Collections.emptyList();
        }
        return (List<Map<String, Object>>) source;
    }

    static Map<String, Object> toMap(Object source) {
        if (source == null) {
            return Collections.emptyMap();
        }
        return (Map<String, Object>) source;
    }
}
