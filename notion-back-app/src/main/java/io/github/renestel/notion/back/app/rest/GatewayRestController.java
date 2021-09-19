package io.github.renestel.notion.back.app.rest;


import io.github.renestel.notion.back.app.domain.service.DeckService;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.rest.gateway.api.GatewayRestApi;
import io.github.renestel.notion.rest.gateway.api.domain.request.GetDecksRequest;
import io.github.renestel.notion.rest.gateway.api.domain.response.GetDecksResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnProperty("server.enabled")
@RequiredArgsConstructor
@RequestMapping(
    value = "/v1/rest",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
)
@OpenAPIDefinition(
    info = @Info(title = "${spring.application.name}", version = "${build.version}")
)
public class GatewayRestController implements GatewayRestApi {

    final DeckService deckService;

    @Override
    @PostMapping("/getDecks")
    @Operation(tags = "Deck", summary = "NOTION_GET_DECKS_REQUEST", description = "Получение колод")
    public ResponseEntity<BaseResponse<GetDecksResponse>> getDecks(@RequestBody GetDecksRequest request) {
        return deckService.getDecks(request);
    }
}
