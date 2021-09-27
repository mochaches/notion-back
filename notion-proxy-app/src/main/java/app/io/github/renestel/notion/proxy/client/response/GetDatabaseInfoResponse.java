package app.io.github.renestel.notion.proxy.client.response;

import app.io.github.renestel.notion.proxy.client.dto.RowDto;
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
public class GetDatabaseInfoResponse {
    List<RowDto> rows;

    @JsonProperty("results")
    private void unpackNestedResults(List<Map<String, Object>> results) {
        this.rows = results.stream()
                .map(e -> {
                    var properties = toMap(e.get("properties"));
                    var id = (String) toMap(toMap(properties.get("id")).get("formula")).get("string");
                    var deck = (String) toMap(toMap(properties.get("Deck")).get("select")).get("name");
                    var side1 = (String) toList(toMap(properties.get("Side1")).get("title")).get(0).get("plain_text");
                    var side2 = (String) toList(toMap(properties.get("Side2")).get("rich_text")).get(0).get("plain_text");
                    var tags = toList(toMap(properties.get("Tags")).get("multi_select")).stream()
                            .map(c -> (String) c.get("name"))
                            .collect(Collectors.toList());
                    var build = RowDto.builder()
                            .id(id)
                            .deck(deck)
                            .side1(side1)
                            .side2(side2)
                            .tags(tags)
                            .build();
                    return build;
                })
                .collect(Collectors.toList());
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
