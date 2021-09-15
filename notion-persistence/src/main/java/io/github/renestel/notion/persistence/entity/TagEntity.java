package io.github.renestel.notion.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tags")
@AllArgsConstructor
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tagsSeqGenerator")
    @SequenceGenerator(name = "tagsSeqGenerator", sequenceName = "tags_seq", allocationSize = 1)
    Long id;
    @Column(name = "name", nullable = false)
    String name;

    @ManyToMany(mappedBy = "tags")
    List<NoteEntity> notes;

}
