package com.zys.divinspringboot.domain;

/**
 * 用户模型
 * @author: zys
 * @date: 2019/7/21 12:08
 */
public class User {

    /**
     * user id
     */
    private Long id;

    /**
     * user name
     */
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
