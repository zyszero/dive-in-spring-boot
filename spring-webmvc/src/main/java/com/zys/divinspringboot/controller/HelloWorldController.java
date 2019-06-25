package com.zys.divinspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello World {@link Controller}
 * @author: zys
 * @date: 2019/6/25 22:10
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
