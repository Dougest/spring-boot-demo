package com.hola.service.dougest;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hola.entity.dougest.City;

/**
 * Created by Dougest on 2017/3/10 0010.
 */
public interface CityService {
    String findCity(Integer id);

    City findCitys(Integer id);
    
    List<City> queryCityList( Integer id);
}
