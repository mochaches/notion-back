package app.io.github.renestel.notion.proxy.client;

import app.io.github.renestel.notion.proxy.client.request.GetDeckRequest;
import app.io.github.renestel.notion.proxy.client.response.GetDeckResponse;
import org.springframework.http.ResponseEntity;

public interface NotionApi {
    ResponseEntity<GetDeckResponse> getVendors(GetDeckRequest body);
}
