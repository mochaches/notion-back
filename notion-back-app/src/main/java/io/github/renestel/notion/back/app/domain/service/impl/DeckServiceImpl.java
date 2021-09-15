package io.github.renestel.notion.back.app.domain.service.impl;

import io.github.renestel.notion.back.app.domain.domain.dto.DeckDto;
import io.github.renestel.notion.back.app.domain.domain.request.GetDeckRequest;
import io.github.renestel.notion.back.app.domain.domain.request.SaveDeckRequest;
import io.github.renestel.notion.back.app.domain.domain.response.GetDeckResponse;
import io.github.renestel.notion.back.app.domain.service.DeckService;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.domain.model.response.base.ResponseStatus;
import io.github.renestel.notion.persistence.repository.DecksRepository;
import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "NOTION-DECK-SERVICE")
public class DeckServiceImpl implements DeckService {

    final ProviderProxy proxy;
    final DecksRepository repository;
    final ModelMapper mapper;

    @Override
    @Transactional
    public ResponseEntity<BaseResponse<GetDeckResponse>> getDeck(GetDeckRequest request) {
        var deckEntity = repository.getById(request.getId());
        var deckDto = mapper.map(deckEntity, DeckDto.class);
        return ResponseEntity.ok(
            BaseResponse
                .<GetDeckResponse>builder()
                .status(ResponseStatus.OK)
                .data(GetDeckResponse.builder()
                    .deck(deckDto)
                    .build())
                .build());
    }

    @Override
    public ResponseEntity<BaseResponse<Void>> saveDeck(SaveDeckRequest request) {
        return null;
    }

}
