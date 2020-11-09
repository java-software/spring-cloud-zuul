package com.software.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    private Integer port;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/get")
    public Object getInfo() {
        return appName + ": " + port;
    }
}
