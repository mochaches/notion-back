package io.github.renestel.anki.proxy.domain.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

import static io.github.renestel.anki.proxy.domain.client.config.JsonMapUtils.toMap;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCardsInfoResponse {
    Long cardId;
    Long noteId;
    String front;
    String back;
    String deckName;

    @JsonProperty("result")
    private void unpackNestedUserTotal(List<Map<String, Object>> results) {
        var sourceCard = results.get(0);
        cardId = (Long) sourceCard.get("cardId");
        noteId = (Long) sourceCard.get("note");
        deckName = (String) sourceCard.get("deckName");
        var fields = toMap(sourceCard.get("fields"));
        front = (String) toMap(fields.get("Front")).get("value");
        back = (String) toMap(fields.get("Back")).get("value");
    }
}
