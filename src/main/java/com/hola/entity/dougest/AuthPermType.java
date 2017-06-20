package com.hola.entity.dougest;

import java.io.Serializable;

/**
 * Created by Dougest on 2017/4/8 0008.
 */
public class AuthPermType implements Serializable {

    private Long id;

    private String name;

    private Integer type;

    private Integer priority;

    private String desc;
    public AuthPermType() {}
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "AuthPermType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", priority=" + priority +
                ", desc='" + desc + '\'' +
                '}';
    }
}
