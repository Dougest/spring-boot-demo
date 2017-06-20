package com.hola.dao.dougest;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hola.entity.dougest.City;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Dougest on 2017/3/10 0010.
 * 持久层里整合了MyBatis和JPA 然后在serivceImpl层理又有自定义JPA自定义sql写法
 * 
 * 注意:一定要控制好事物!防止JPA和MyBatis运行sql时数据异常!!!!  
 */
@Mapper		//Mybatis注解
public interface CityDao{
    @Select("SELECT Name FROM CITY  WHERE ID = #{id}")
    String findCity(@Param("id") Integer id);

    City findCitys(Integer id);
    
    
    
    
}
