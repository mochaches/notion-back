package app.io.github.renestel.notion.proxy.client.config;

import notion.back.utils.rest.HttpClientConfigurer;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;

@Configuration
public class NotionConfig extends HttpClientConfigurer {
    @Bean
    public UriBuilderFactory createUriBuilderFactory(NotionProperties properties) {
        return new DefaultUriBuilderFactory(
                UriComponentsBuilder
                        .newInstance()
                        .scheme(properties.getSchema())
                        .host(properties.getHost())
                        .port(properties.getPort())
                        .path(properties.getBasePath())
        );
    }

    @Bean("rest.simple")
    public RestTemplate createBearerInterceptorRestTemplate(
            NotionProperties properties,
            @Qualifier("custom.client.http.request.factory") ClientHttpRequestFactory clientHttpRequestFactory,
            RestTemplateBuilder restTemplateBuilder
    ) {
        return restTemplateBuilder
                .requestFactory(() -> clientHttpRequestFactory)
                .setConnectTimeout(Duration.ofMillis(properties.getConnectionTimeout()))
                .setReadTimeout(Duration.ofMillis(properties.getReadTimeout()))
                .build();
    }

    @Bean("custom.client.http.request.factory")
    public ClientHttpRequestFactory createRequestFactory(
            NotionProperties properties,
            HttpRequestInterceptor requestInterceptor,
            HttpResponseInterceptor responseInterceptor
    ) {
        return new BufferingClientHttpRequestFactory(
                super.createRequestFactory(
                        properties,
                        requestInterceptor,
                        responseInterceptor
                )
        );
    }
}