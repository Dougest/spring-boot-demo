package com.hola.entity.dougest;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Dougest on 2017/3/28 0028.
 */
//@Entity
public class User implements Serializable{
    //****************没有默认构造会报错 *******************
    public User(){}

    private Long userId;

    private String userName;

    private String userPwd;

    private String status;

    private Integer age;
    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }
    //@Column(name="status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
//    @Id
//    @Column(name="user_id")
//    @GeneratedValue
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
   // @Column(name="user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
 //   @Column(name="user_pwd")
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
 //   @Column(name="age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", status='" + status + '\'' +
                ", age=" + age +
                '}';
    }
}
