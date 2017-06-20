package com.hola.entity.dougest;

import java.io.Serializable;

/**
 * Created by Dougest on 2017/4/8 0008.
 */
public class AuthAccess implements Serializable {
    private Long id;

    private String type;

    private String value;

    private Long permId;

    private Integer priority;

    private String desc;
    public AuthAccess() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getPermId() {
        return permId;
    }

    public void setPermId(Long permId) {
        this.permId = permId;
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
        return "AuthAccess{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", permId=" + permId +
                ", priority=" + priority +
                ", desc='" + desc + '\'' +
                '}';
    }
}
