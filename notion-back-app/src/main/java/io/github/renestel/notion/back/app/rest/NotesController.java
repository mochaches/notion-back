package io.github.renestel.notion.back.app.rest;

import io.github.renestel.notion.persistence.entity.NoteEntity;
import io.github.renestel.notion.persistence.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NotesController {

    final NoteRepository noteRepository;

    @PostMapping("/addNewNotes")
    public String addNewNotes(@RequestParam Long id, @RequestParam String name,
                              @RequestParam String side1, @RequestParam String side2) {
        NoteEntity notes = new NoteEntity();
        notes.setId(id);
        notes.setName(name);
        notes.setSide1(side1);
        notes.setSide2(side2);
        notes.setDeck(notes.getDeck());
        noteRepository.save(notes);
        return "New notes added";
    }

    @GetMapping("/findNotesById")
    public NoteEntity findNotesById(Long id) {
        return noteRepository.getById(id);
    }

    @GetMapping("/findAllNotes")
    public List<NoteEntity> findAllNotes() {
        return noteRepository.findAll();
    }

    @DeleteMapping("/removeNotes")
    public String removeNotesById(Long id) {
        noteRepository.deleteById(id);
        return "200 OK";
    }

}
