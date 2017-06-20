package com.hola.service.dougest;

import com.hola.entity.dougest.AuthUser;

/**
 * Created by Dougest on 2017/4/8 0008.
 */
public interface AuthUserService {
    AuthUser findUserByUserName(String userName);
}
