package app.io.github.renestel.notion.proxy.client.request;

import app.io.github.renestel.notion.proxy.client.dto.SortDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetDatabaseInfoRequest {
    List<SortDto> sorts;
}
