package com.software.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author gaohu9712@163.com
 * @date 2020/11/9
 * @description 信息服务
 */
@RestController
@RequestMapping("/info")
public class InfoController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/get")
    public Object getInfo(HttpServletRequest request) {
        return new HashMap<String, String>() {{
           this.put("请求路径：", request.getRequestURL().toString());
           this.put("请求服务：", appName);
           this.put("请求端口：", port);
        }};
    }
}
