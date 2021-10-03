package io.github.renestel.notion.provider.proxy.client.config;

import lombok.Getter;
import lombok.Setter;
import notion.back.utils.rest.BaseRestClientProperties;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProviderProxyProperties extends BaseRestClientProperties {
    String schema;
    String host;
    Integer port;
    String basePath;
    ServicePath paths;

    @Getter
    @Setter
    public static class ServicePath {
        @NotNull
        String getDecks;
        @NotNull
        String removeCards;
        @NotNull
        String addCards;
    }
}
