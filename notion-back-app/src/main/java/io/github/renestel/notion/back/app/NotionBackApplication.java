package io.github.renestel.notion.back.app;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "io.github.renestel.notion.persistence.entity")
@EnableJpaRepositories(basePackages = "io.github.renestel.notion.persistence.repository")
@SpringBootApplication
public class NotionBackApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(NotionBackApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .registerShutdownHook(true)
                .run();
    }
}

