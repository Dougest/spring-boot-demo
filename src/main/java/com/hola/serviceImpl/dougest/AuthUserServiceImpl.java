package com.hola.serviceImpl.dougest;

import com.hola.dao.dougest.AuthUserDao;
import com.hola.entity.dougest.AuthUser;
import com.hola.service.dougest.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dougest on 2017/4/8 0008.
 */
@Service
public class AuthUserServiceImpl implements AuthUserService{

    @Autowired
    private AuthUserDao authUserDao;


    @Override
    public AuthUser findUserByUserName(String userName) {
        return authUserDao.findUserByUserName(userName);
    }
}
