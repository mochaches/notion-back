package app.io.github.renestel.notion.proxy.client;

import app.io.github.renestel.notion.proxy.client.request.GetDatabaseInfoRequest;
import app.io.github.renestel.notion.proxy.client.response.GetDatabaseInfoResponse;
import app.io.github.renestel.notion.proxy.client.response.GetDatabaseResponse;
import io.github.renestel.notion.provider.proxy.api.request.GetDeckProxyRequest;
import org.springframework.http.ResponseEntity;

public interface NotionApi {

    ResponseEntity<GetDatabaseResponse> getDatabase(GetDeckProxyRequest body);

    ResponseEntity<GetDatabaseInfoResponse> getDatabaseInfo(String token, String database, GetDatabaseInfoRequest body);
}
