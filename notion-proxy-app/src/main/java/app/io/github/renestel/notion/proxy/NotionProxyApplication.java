package app.io.github.renestel.notion.proxy;

import app.io.github.renestel.notion.proxy.client.config.NotionProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({NotionProperties.class})
public class NotionProxyApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(NotionProxyApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .registerShutdownHook(true)
                .run();
    }
}
