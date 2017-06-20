package com.hola.dao.dougest;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * Created by Dougest on 2017/4/9 0009.
 */
@Mapper
public interface AuthRoleDao {
    Set<String> findRoles(Long id);
}
