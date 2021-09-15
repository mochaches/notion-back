package io.github.renestel.notion.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "decks")
@EqualsAndHashCode(exclude = {"id", "notes"})
public class DeckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "decksSeqGenerator")
    @SequenceGenerator(name = "decksSeqGenerator", sequenceName = "decks_seq", allocationSize = 1)
    Long id;
    @Column(name = "name", nullable = false)
    String name;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL)
    Set<NoteEntity> notes;
}

