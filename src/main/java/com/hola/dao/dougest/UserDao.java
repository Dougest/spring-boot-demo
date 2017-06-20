package com.hola.dao.dougest;

import org.apache.ibatis.annotations.Mapper;

import com.hola.entity.dougest.User;

import java.util.List;

/**
 * Created by Dougest on 2017/3/10 0010.
 */
@Mapper
public interface UserDao {

    User findUserByUser(User user);

    User findUserByUserName(String userName);

    void updateUser(User user);

    User insertUser(User user);

    void deleteUser(User user);

    void addMore (List<User> list);

}
