package com.hola.serviceImpl.dougest;

import com.hola.dao.dougest.AuthRoleDao;
import com.hola.service.dougest.AuthRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Dougest on 2017/4/9 0009.
 */
@Service
public class AuthRoleServiceImpl implements AuthRoleService{
    @Autowired
    private AuthRoleDao authRoleDao;

    @Override
    public Set<String> findRoles(Long id) {
        return authRoleDao.findRoles(id);
    }
}
