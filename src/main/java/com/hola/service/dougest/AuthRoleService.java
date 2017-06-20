package com.hola.service.dougest;

import java.util.Set;

import com.hola.entity.dougest.AuthRole;

/**
 * Created by Dougest on 2017/4/9 0009.
 */
public interface AuthRoleService {


    Set<String> findRoles(Long id);
}
