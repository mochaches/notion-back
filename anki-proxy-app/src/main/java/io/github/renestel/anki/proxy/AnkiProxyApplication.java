package io.github.renestel.anki.proxy;

import io.github.renestel.anki.proxy.domain.client.config.AnkiProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AnkiProperties.class})
public class AnkiProxyApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AnkiProxyApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .logStartupInfo(false)
            .registerShutdownHook(true)
            .run();
    }
}
