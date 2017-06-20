package com.hola.entity.dougest;

import java.io.Serializable;

/**
 * Created by Dougest on 2017/3/28 0028.
 */
public class AuthRole implements Serializable{
    private Long id;

    private String name;

    private String desc;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public AuthRole() {}

    @Override
    public String toString() {
        return "AuthRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
