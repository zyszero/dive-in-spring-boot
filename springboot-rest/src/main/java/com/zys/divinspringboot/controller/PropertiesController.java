package com.zys.divinspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Properties;

/**
 * @author: zys
 * @date: 2019/7/24 23:20
 */
//@RestController
@Controller
public class PropertiesController {


    @PostMapping(value = "/add/prop",
            consumes = "text/properties;charset=UTF-8" // 过滤媒体类型
    )
    public Properties user(/*@RequestBody*/ Properties properties) {
        return properties;
    }
}
