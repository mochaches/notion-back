package app.io.github.renestel.notion.proxy.client.config;

import lombok.Getter;
import lombok.Setter;
import notion.back.utils.rest.BaseRestClientProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "notion")
public class NotionProperties extends BaseRestClientProperties {
    @Pattern(regexp = "^(http)(s?)$")
    String schema;
    @NotEmpty
    String host;
    @NotNull
    Integer port;
    @NotEmpty
    String basePath;
    @NotNull
    ServicePath paths;

    @Getter
    @Setter
    public static class BasicAuth {

        @NotEmpty
        private String login;

        @NotEmpty
        private String password;
    }

    @Getter
    @Setter
    public static class ServicePath {

        @NotBlank
        private String databases;

        @NotBlank
        private String queryDatabases;
    }
}
