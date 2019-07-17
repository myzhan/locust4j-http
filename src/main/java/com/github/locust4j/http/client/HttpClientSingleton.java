package com.github.locust4j.http.client;

import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @author myzhan
 */
public class HttpClientSingleton {

    /**
     * Don't call new HttpClientSingleton()
     */
    private HttpClientSingleton() {

    }

    public static CloseableHttpClient getInstance() {
        return HttpClientSingleton.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CloseableHttpClient INSTANCE = createInstance();

        private static CloseableHttpClient createInstance() {
            HttpClientBuilder builder = HttpClientBuilder.create();

            SocketConfig.Builder socketConfigBuilder = SocketConfig.custom();
            socketConfigBuilder.setSoKeepAlive(true);
            socketConfigBuilder.setTcpNoDelay(true);
            builder.setDefaultSocketConfig(socketConfigBuilder.build());

            PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager();
            connMgr.setMaxTotal(1024);
            connMgr.setDefaultMaxPerRoute(1024);
            builder.setConnectionManager(connMgr);

            return builder.build();
        }
    }
}
