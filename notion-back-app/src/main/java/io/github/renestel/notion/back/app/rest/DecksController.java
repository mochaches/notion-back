package io.github.renestel.notion.back.app.rest;

import io.github.renestel.notion.back.app.domain.model.dto.OrderRequest;
import io.github.renestel.notion.persistence.entity.DeckEntity;
import io.github.renestel.notion.persistence.repository.DecksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DecksController {

    final DecksRepository decksRepository;

    @PostMapping("/placeDecks")
    public DeckEntity placeOrder(@RequestBody OrderRequest request) {
        return decksRepository.save(request.getDeckEntity());
    }

    @DeleteMapping
    public String deleteDeckById(@RequestParam Long id) {
        decksRepository.deleteById(id);
        return id + " deck remove";
    }

    @PostMapping("/add")
    public String addNewDeck(@RequestBody String name) {
        DeckEntity deckEntity = new DeckEntity();
        deckEntity.setName(name);
        decksRepository.save(deckEntity);
        return "Deck added!";
    }

    @GetMapping("/findAllDecks")
    public List<DeckEntity> findAllDecks() {
        return decksRepository.findAll();
    }

    @GetMapping("/findDeckById")
    public DeckEntity findDeckById(@RequestParam Long id) {
        return decksRepository.getById(id);
    }

}
