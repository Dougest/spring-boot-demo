package com.hola.entity.dougest;

import java.io.Serializable;

/**
 * Created by Dougest on 2017/4/8 0008.
 */
public class AuthMenu implements Serializable {

    private Long id;

    private String type;

    private String code;

    private String title;

    private String url;

    private Integer priority;

    private String desc;

    private Long parent_id;

    private Long perm_id;

    private String display;

    public AuthMenu() {}

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Long getPerm_id() {
        return perm_id;
    }

    public void setPerm_id(Long perm_id) {
        this.perm_id = perm_id;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "AuthMenu{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", priority=" + priority +
                ", desc='" + desc + '\'' +
                ", parent_id=" + parent_id +
                ", perm_id=" + perm_id +
                ", display='" + display + '\'' +
                '}';
    }
}
