package com.hola.serviceImpl.dougest;

import com.hola.dao.dougest.CityDao;
import com.hola.dao.dougest.CityDaoJPA;
import com.hola.entity.dougest.City;
import com.hola.service.dougest.CityService;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private  CityDao cityDao;
    @Autowired
    private CityDaoJPA cityDaoJPA;
    
    @Override
    public String findCity(Integer id) {
        return cityDao.findCity(id);
    }

    @Override
    public City findCitys(Integer id) {
        return cityDao.findCitys(id);
    }

	@Override
	public List<City> queryCityList(Integer id) {
		return cityDaoJPA.queryCityList(id);
	}
}
