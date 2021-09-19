package io.github.renestel.notion.persistence.repository;

import io.github.renestel.notion.persistence.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
}
