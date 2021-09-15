package io.github.renestel.notion.back.app.domain.model.dto;

import io.github.renestel.notion.persistence.entity.DeckEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    DeckEntity deckEntity;
}
