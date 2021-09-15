package notion.back.utils.rest;

import lombok.SneakyThrows;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.springframework.boot.web.server.Ssl;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

public class HttpClientConfigurer {
    @SneakyThrows
    public ClientHttpRequestFactory createRequestFactory(
        BaseRestClientProperties properties,
        HttpRequestInterceptor requestInterceptor,
        HttpResponseInterceptor responseInterceptor
    ) {

        LayeredConnectionSocketFactory socketFactory;

        if (properties.getSsl().isEnabled()) {

            if (properties.getSsl().getClientAuth() == Ssl.ClientAuth.NONE) {

                socketFactory = new SSLConnectionSocketFactory(
                    SSLContexts
                        .custom()
                        .setProtocol(properties.getSsl().getProtocol())
                        .loadTrustMaterial(new File(properties.getSsl().getTrustStore()), properties.getSsl().getTrustStorePassword().toCharArray())
                        .build(),
                    new DefaultHostnameVerifier()
                );

            } else {

                var keystore = KeyStore.getInstance(properties.getSsl().getKeyStoreType());
                try (var store = new FileInputStream(properties.getSsl().getKeyStore())) {
                    keystore.load(store, properties.getSsl().getKeyStorePassword().toCharArray());
                }

                socketFactory = new SSLConnectionSocketFactory(
                    SSLContexts
                        .custom()
                        .setProtocol(properties.getSsl().getProtocol())
                        .loadKeyMaterial(keystore, properties.getSsl().getKeyStorePassword().toCharArray())
                        .loadTrustMaterial(new File(properties.getSsl().getTrustStore()), properties.getSsl().getTrustStorePassword().toCharArray())
                        .build(),
                    new DefaultHostnameVerifier()
                );
            }

        } else {

            socketFactory = new SSLConnectionSocketFactory(
                SSLContexts
                    .custom()
                    .setProtocol(properties.getSsl().getProtocol())
                    .loadTrustMaterial(TrustAllStrategy.INSTANCE)
                    .build(),
                NoopHostnameVerifier.INSTANCE
            );

        }

        var connectionManager = new PoolingHttpClientConnectionManager(
            RegistryBuilder
                .<ConnectionSocketFactory>create()
                .register("https", socketFactory)
                .register("http", new PlainConnectionSocketFactory())
                .build()
        );

        if (properties.getMaxTotalConnections() != null)
            connectionManager.setMaxTotal(properties.getMaxTotalConnections());
        if (properties.getMaxDefaultPerRouteConnections() != null)
            connectionManager.setDefaultMaxPerRoute(properties.getMaxDefaultPerRouteConnections());

        connectionManager.setValidateAfterInactivity(10 * 1000);

        var httpClient = HttpClients
            .custom()
            .setConnectionManager(connectionManager)
            .setRetryHandler(new DefaultHttpRequestRetryHandler(3, true))
            .addInterceptorFirst(requestInterceptor)
            .addInterceptorFirst(responseInterceptor)
            .disableCookieManagement()
            .build();

        var requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        if (properties.getConnectionTimeout() != null)
            requestFactory.setConnectTimeout(properties.getConnectionTimeout());
        if (properties.getReadTimeout() != null)
            requestFactory.setReadTimeout(properties.getReadTimeout());

        return requestFactory;
    }
}
