package com.staylog.staylog.global.config;

import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate 설정
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        // Connection Pool 설정
        PoolingHttpClientConnectionManager connectionManager =
            new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(100);        // 최대 연결 수
        connectionManager.setDefaultMaxPerRoute(20); // 라우트당 최대 연결 수

        // HttpClient 생성
        var httpClient = HttpClients.custom()
            .setConnectionManager(connectionManager)
            .build();

        // Request Factory 설정
        HttpComponentsClientHttpRequestFactory factory =
            new HttpComponentsClientHttpRequestFactory(httpClient);
        factory.setConnectTimeout(5000);      // 연결 타임아웃 5초
        factory.setConnectionRequestTimeout(5000); // Connection Pool에서 가져오는 타임아웃

        return new RestTemplate(factory);
    }
}
