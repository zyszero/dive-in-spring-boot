package com.zys.divinspringboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * @author: zys
 * @date: 2019/7/24 23:20
 */
@RestController
public class PropertiesController {


    @PostMapping(value = "/add/prop",
            consumes = "text/properties;charset=UTF-8" // 过滤媒体类型
    )
    public Properties user(@RequestBody Properties properties) {
        return properties;
    }
}
