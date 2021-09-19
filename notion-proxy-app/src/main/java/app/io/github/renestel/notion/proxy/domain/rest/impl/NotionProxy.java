package app.io.github.renestel.notion.proxy.domain.rest.impl;

import app.io.github.renestel.notion.proxy.client.NotionApi;
import app.io.github.renestel.notion.proxy.client.dto.SortDto;
import app.io.github.renestel.notion.proxy.client.request.GetDatabaseInfoRequest;
import app.io.github.renestel.notion.proxy.domain.rest.ProviderProxyResponseHandler;
import io.github.renestel.notion.domain.model.response.base.BaseResponse;
import io.github.renestel.notion.domain.model.response.base.ResponseStatus;
import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import io.github.renestel.notion.provider.proxy.api.ProxyLogicException;
import io.github.renestel.notion.provider.proxy.api.request.GetDecksProxyRequest;
import io.github.renestel.notion.provider.proxy.api.response.GetDecksProxyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@Slf4j(topic = "NOTION-PROXY-SERVICE")
public class NotionProxy implements ProviderProxy {
    final NotionApi notionApi;
    final ModelMapper mapper;

    @Override
    public ResponseEntity<BaseResponse<GetDecksProxyResponse>> getDecks(GetDecksProxyRequest request) throws ProxyLogicException {
        var data = ProviderProxyResponseHandler.getResponseData(notionApi.getDatabaseInfo(
            request.getUser(),
            request.getDatabase(),
            GetDatabaseInfoRequest.builder()
                .sorts(Collections.singletonList(SortDto.builder()
                    .property("Side1")
                    .direction("ascending")
                    .build()))
                .build()));
        var result = mapper.map(data, GetDecksProxyResponse.class);

        return ResponseEntity.ok(
            BaseResponse.<GetDecksProxyResponse>builder()
                .status(ResponseStatus.OK)
                .data(result)
                .build()
        );
    }

    @Override
    public String getProviderName() {
        return null;
    }
}
