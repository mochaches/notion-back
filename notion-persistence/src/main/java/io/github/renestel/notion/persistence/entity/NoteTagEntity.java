package io.github.renestel.notion.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "note_tags")
public class NoteTagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_tagsSeqGenerator")
    @SequenceGenerator(name = "note_tagsSeqGenerator", sequenceName = "note_tags_seq", allocationSize = 1)
    Long id;
    @Column(name = "note_id", nullable = false)
    String noteId;
    @Column(name = "tag_id", nullable = false)
    String tagId;

}
