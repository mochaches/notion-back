package io.github.renestel.notion.back.app.domain.config;

import io.github.renestel.notion.provider.proxy.client.config.ProviderProxyProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientPropertiesConfig {

    @Bean
    @ConfigurationProperties(prefix = "notion.proxy")
    public ProviderProxyProperties createNotionProxyProperties() {
        return new ProviderProxyProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "anki.proxy")
    public ProviderProxyProperties createAnkiProxyProperties() {
        return new ProviderProxyProperties();
    }
}
