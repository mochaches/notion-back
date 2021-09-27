package app.io.github.renestel.notion.proxy.rest;

import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import io.github.renestel.notion.provider.proxy.api.ProxyLogicException;
import io.github.renestel.notion.provider.proxy.api.request.GetDeckProxyRequest;
import io.github.renestel.notion.provider.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.provider.proxy.api.response.GetDeckProxyResponse;
import io.github.renestel.notion.provider.proxy.api.response.GetDecksProxyResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnProperty("server.enabled")
@RequiredArgsConstructor
@RequestMapping("/v1/rest/notion")
@OpenAPIDefinition(
        info = @Info(title = "Notion Proxy API")
)
@Slf4j(topic = "PROXY-CONTROLLER")
public class ProxyController implements ProviderProxy {
    final ProviderProxy service;

//    @Override
//    @PostMapping("/getDeck")
//    @Operation(tags = "decks", summary = "Get deck info")
//    public ResponseEntity<BaseResponse<GetDeckProxyResponse>> getDeck(@RequestBody GetDeckProxyRequest request) throws ProxyLogicException {
//        return service.getDeck(request);
//    }

    @Override
    @PostMapping("/getDecks")
    @Operation(tags = "decks", summary = "Get all deck info")
    public ResponseEntity<BaseResponse<GetDecksProxyResponse>> getDecks(@RequestBody GetDecksProxyRequest request) throws ProxyLogicException {
        return service.getDecks(request);
    }

    @Override
    public String getProviderName() {
        return null;
    }
}
