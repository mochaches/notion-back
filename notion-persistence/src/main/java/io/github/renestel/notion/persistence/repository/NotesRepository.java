package io.github.renestel.notion.persistence.repository;

import io.github.renestel.notion.persistence.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<NoteEntity, Long> {

}
