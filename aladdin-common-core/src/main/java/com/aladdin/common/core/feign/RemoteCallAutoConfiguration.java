package com.aladdin.common.core.feign;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 远程调用自动配置
 *
 * @author cles
 * @date 2026/05/06
 */
@Configuration
public class RemoteCallAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(10000);
        return new RestTemplate(factory);
    }

    @Bean
    @ConditionalOnMissingBean
    public RemoteCallUtil remoteCallUtil(RestTemplate restTemplate) {
        return new RemoteCallUtil(restTemplate);
    }
}
