package com.aladdin.common.core.feign;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.aladdin.common.core.domain.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 远程调用工具
 *
 * @author cles
 * @date 2026/05/06
 */
public class RemoteCallUtil {

    private static final Logger log = LoggerFactory.getLogger(RemoteCallUtil.class);

    private final RestTemplate restTemplate;

    public RemoteCallUtil(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> R<T> get(String url, Class<T> responseType) {
        return get(url, null, responseType);
    }

    public <T> R<T> get(String url, Map<String, String> headers, Class<T> responseType) {
        try {
            HttpHeaders httpHeaders = buildHeaders(headers);
            HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return parseResponse(response.getBody(), responseType);
        } catch (Exception e) {
            log.error("远程调用失败: GET {} - {}", url, e.getMessage());
            return R.fail("远程调用失败: " + e.getMessage());
        }
    }

    public <T> R<T> post(String url, Object body, Class<T> responseType) {
        return post(url, body, null, responseType);
    }

    public <T> R<T> post(String url, Object body, Map<String, String> headers, Class<T> responseType) {
        try {
            HttpHeaders httpHeaders = buildHeaders(headers);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Object> entity = new HttpEntity<>(body, httpHeaders);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            return parseResponse(response.getBody(), responseType);
        } catch (Exception e) {
            log.error("远程调用失败: POST {} - {}", url, e.getMessage());
            return R.fail("远程调用失败: " + e.getMessage());
        }
    }

    private HttpHeaders buildHeaders(Map<String, String> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null) {
            headers.forEach(httpHeaders::set);
        }
        return httpHeaders;
    }

    @SuppressWarnings("unchecked")
    private <T> R<T> parseResponse(String body, Class<T> responseType) {
        if (body == null) {
            return R.fail("远程调用返回为空");
        }
        try {
            R<Map<String, Object>> raw = JSON.parseObject(body, new TypeReference<R<Map<String, Object>>>() {});
            if (raw.getData() != null && responseType != Void.class) {
                T data = JSON.parseObject(JSON.toJSONString(raw.getData()), responseType);
                R<T> result = new R<>();
                result.setCode(raw.getCode());
                result.setMsg(raw.getMsg());
                result.setData(data);
                return result;
            }
            R<T> result = new R<>();
            result.setCode(raw.getCode());
            result.setMsg(raw.getMsg());
            return result;
        } catch (Exception e) {
            log.error("解析远程调用响应失败: {}", e.getMessage());
            return R.fail("解析远程调用响应失败");
        }
    }
}
