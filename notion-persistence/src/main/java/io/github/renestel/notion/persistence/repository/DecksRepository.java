package io.github.renestel.notion.persistence.repository;


import io.github.renestel.notion.persistence.entity.DeckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecksRepository extends JpaRepository<DeckEntity, Long> {
}
