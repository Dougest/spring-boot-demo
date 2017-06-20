package com.hola.dao.dougest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hola.entity.dougest.City;
/**
 * 
 * @author Dougest 2017年5月8日    下午11:16:45
 *
 */
@Repository  //注意添加@Repository注解， 添加JpaSpecificationExecutor继承可以方便分页
public interface CityDaoJPA extends PagingAndSortingRepository<City, Integer>, JpaSpecificationExecutor<City>{
	@Query("from city t where id = :id") 
    List<City> queryCityList(@Param("id") Integer id);
}
