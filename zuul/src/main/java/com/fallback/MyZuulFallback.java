package com.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Demo_Null
 * @date 2020/11/9
 * @description
 */
@Component
public class MyZuulFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        // getRoute 方法返回 "info-server"，即为 "info-server" 提供回退
        // 如果要为所有路由提供默认回退，可以返回 * 或 null
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            // 响应状态码
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            // 状态码
            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            // 响应状态信息
            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {
            }

            // 异常体信息
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("服务故障，请稍后重试!".getBytes());
            }

            // 响应头
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };

    }

}
