package com.zys.divinspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zys
 * @date: 2019/7/3 23:58
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWroldControllerAdvice {

    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue("Hm_lvt_1dfa88d0c8571eef2d383070cb3e5ca1") String jsession) {
        return jsession;
    }

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
        return acceptLanguage;
    }

    @ModelAttribute("message")
    public String message() {
        return "Hello World！";
    }


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable) {
        return ResponseEntity.ok(throwable.getMessage());
    }

}
