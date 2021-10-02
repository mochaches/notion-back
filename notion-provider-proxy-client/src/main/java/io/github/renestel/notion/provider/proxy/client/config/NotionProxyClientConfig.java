package io.github.renestel.notion.provider.proxy.client.config;

import io.github.renestel.notion.provider.proxy.api.ProviderProxy;
import io.github.renestel.notion.provider.proxy.client.ProviderProxyClient;
import notion.back.utils.rest.HttpClientConfigurer;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
@EnableRetry
public class NotionProxyClientConfig extends HttpClientConfigurer {

    @Bean("notion.proxy.client")
    public UriBuilderFactory createUriBuilderFactory(@Qualifier("createNotionProxyProperties") ProviderProxyProperties properties) {
        return new DefaultUriBuilderFactory(
            UriComponentsBuilder
                .newInstance()
                .scheme(properties.getSchema())
                .host(properties.getHost())
                .port(properties.getPort())
                .path(properties.getBasePath())
        );
    }

    @Bean("notion.proxy.client.rest.template")
    public RestTemplate createRestTemplate(
        @Qualifier("createAnkiProxyProperties") ProviderProxyProperties properties,
        HttpRequestInterceptor requestInterceptor,
        HttpResponseInterceptor responseInterceptor,
        RestTemplateBuilder restTemplateBuilder
    ) {
        return restTemplateBuilder
            .requestFactory(
                () -> new BufferingClientHttpRequestFactory(
                    super.createRequestFactory(
                        properties,
                        requestInterceptor,
                        responseInterceptor
                    )
                )
            )
            .build();
    }

    @Bean
    public ProviderProxy notion(
        @Qualifier("notion.proxy.client") UriBuilderFactory uriBuilderFactory,
        @Qualifier("createAnkiProxyProperties") ProviderProxyProperties properties,
        @Qualifier("notion.proxy.client.rest.template") RestTemplate restClient) {
        return new ProviderProxyClient(uriBuilderFactory, properties, restClient, "notion");
    }
}
