package io.github.renestel.notion.rest.gateway.client.config;

import lombok.Getter;
import lombok.Setter;
import notion.back.utils.rest.BaseRestClientProperties;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GatewayRestClientProperties extends BaseRestClientProperties {
    String schema;
    String host;
    Integer port;
    String basePath;
    ServicePath paths;

    @Getter
    @Setter
    public static class ServicePath {
        @NotNull
        String decks;
        @NotNull
        String removeCards;
        @NotNull
        String addCards;
    }
}


//    @Bean("anki.proxy.client")
//    public UriBuilderFactory createUriBuilderFactory(@Qualifier("createAnkiProxyProperties") ProviderProxyProperties properties) {
//        return new DefaultUriBuilderFactory(
//            UriComponentsBuilder
//                .newInstance()
//                .scheme(properties.getSchema())
//                .host(properties.getHost())
//                .port(properties.getPort())
//                .path(properties.getBasePath())
//        );
//    }
//
//    @Bean("anki.proxy.client.rest.template")
//    public RestTemplate createRestTemplate(
//        @Qualifier("createAnkiProxyProperties") ProviderProxyProperties properties,
//        HttpRequestInterceptor requestInterceptor,
//        HttpResponseInterceptor responseInterceptor,
//        RestTemplateBuilder restTemplateBuilder
//    ) {
//        return restTemplateBuilder
//            .requestFactory(
//                () -> new BufferingClientHttpRequestFactory(
//                    super.createRequestFactory(
//                        properties,
//                        requestInterceptor,
//                        responseInterceptor
//                    )
//                )
//            )
//            .build();
//    }
//
//    @Bean
//    public ProviderProxy createAnkiProxy(
//        @Qualifier("anki.proxy.client") UriBuilderFactory uriBuilderFactory,
//        @Qualifier("createAnkiProxyProperties") ProviderProxyProperties properties,
//        @Qualifier("anki.proxy.client.rest.template") RestTemplate restClient) {
//        return new ProviderProxyClient(uriBuilderFactory, properties, restClient, "anki");
//    }
