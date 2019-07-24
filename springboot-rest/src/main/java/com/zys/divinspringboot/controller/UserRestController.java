package com.zys.divinspringboot.controller;

import com.zys.divinspringboot.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User {@link RestController}
 *
 * @author: zys
 * @date: 2019/7/21 12:07
 */
@RestController
public class UserRestController {

    @PostMapping(value = "/echo/user",
            consumes = "application/json;charset=UTF-8",
            produces = "application/json;charset=UTF-8")
    public User user(@RequestBody User user) {
        return user;
    }
}
