package com.hola.dao.dougest;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hola.entity.dougest.AuthUser;

/**
 * Created by Dougest on 2017/4/8 0008.
 */
@Mapper
public interface AuthUserDao {
    @Select("select * from auth_user where username=#{userName}")
    AuthUser findUserByUserName(String userName);
}
