package io.github.renestel.notion.rest.gateway.client.config;

import io.github.renestel.notion.rest.gateway.api.GatewayRestApi;
import io.github.renestel.notion.rest.gateway.client.GatewayRestClient;
import notion.back.utils.rest.HttpClientConfigurer;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class GatewayRestClientConfig extends HttpClientConfigurer {

    @Bean
    public UriBuilderFactory uriBuilderFactory(GatewayRestClientProperties properties) {
        return new DefaultUriBuilderFactory(UriComponentsBuilder.newInstance()
            .scheme(properties.getSchema())
            .host(properties.getHost())
            .port(properties.getPort())
            .path(properties.getBasePath()));
    }

    @Bean("gateway.client.rest.template")
    public RestTemplate createRestTemplate(
        GatewayRestClientProperties properties,
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
    public GatewayRestApi createNotionProxy(
        UriBuilderFactory uriBuilderFactory,
        GatewayRestClientProperties properties,
        @Qualifier("gateway.client.rest.template") RestTemplate restClient) {
        return new GatewayRestClient(uriBuilderFactory, properties, restClient);
    }
}
