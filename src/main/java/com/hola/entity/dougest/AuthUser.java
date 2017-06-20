package com.hola.entity.dougest;

import java.io.Serializable;

/**
 * Created by Dougest on 2017/4/8 0008.
 */
public class AuthUser implements Serializable {
    private Long id;

    private String username;

    private String password;

    private Integer status;

    private String ref;

    private Long roleId;



    public AuthUser() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public AuthUser(Long id, String username, String password, Integer status, String ref, Long roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.ref = ref;
        this.roleId = roleId;
    }
    @Override
    public String toString() {
        return "AuthUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", ref='" + ref + '\'' +
                ", roleId=" + roleId +
                '}';
    }

}
