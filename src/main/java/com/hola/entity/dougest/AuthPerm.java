package com.hola.entity.dougest;

import java.io.Serializable;

/**
 * Created by Dougest on 2017/4/8 0008.
 */
public class AuthPerm implements Serializable {

    private Long id;

    private String code;

    private String name;

    private Long permTypeId;

    private Integer priority;

    public AuthPerm() {}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPermTypeId() {
        return permTypeId;
    }

    public void setPermTypeId(Long permTypeId) {
        this.permTypeId = permTypeId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "AuthPerm{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", permTypeId=" + permTypeId +
                ", priority=" + priority +
                '}';
    }
}
