package com.zys.divinspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloWorld {@link Controller}
 *
 * @author: zys
 * @date: 2019/7/14 0:04
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String index(@RequestParam(required = false, defaultValue = "0") int value, Model model) {
        return "index";
    }

    @GetMapping
    public String helloWorld() {
        return "hello-world";
    }

    @ModelAttribute("message")
    public String message() {
        return "hello world";
    }
}
