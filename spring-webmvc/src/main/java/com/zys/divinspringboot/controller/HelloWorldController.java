package com.zys.divinspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Hello World {@link Controller}
 *
 * @author: zys
 * @date: 2019/6/25 22:10
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String index(@RequestParam int value) {
//        model.addAttribute("acceptLanguage", acceptLanguage);
//        model.addAttribute("jsessionId", jsessionId);
//        model.addAttribute("message", "Hello,World");
        return "index";
    }

//    @ModelAttribute("message")
//    public String message() {
//        return "Hello World";
//    }
}
