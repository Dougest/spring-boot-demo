package com.hola.util;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 
 * @author Dougest 2017年5月8日    下午10:17:36
 * MyBatis SqlSession获取工具类，提供SqlSession生成，是一个安全的单例类
 */
public class MyBatisUtil {
	 private SqlSessionFactory sqlSessionFactory;  
	    private static MyBatisUtil myBatisUtil;  
	      
	    private MyBatisUtil(DataSource dataSource){  
	          
	        System.out.println("--------------------------myBatis initialize-----------------------");  
	        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();  
	        sqlSessionFactoryBean.setDataSource(dataSource);   
	        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();             
	        try {  
	            //System.out.println(this.getClass().getResource("/MyBatisMapper.xml").toURI().toString());  
	            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/MyBatisMapper.xml"));  
	            //System.out.println(sqlSessionFactoryBean.getObject() + ":" + dataSource);  
	            sqlSessionFactory = sqlSessionFactoryBean.getObject();  
	        } catch (Exception e) {  
	            throw new RuntimeException("MyBatis SqlSessionFactory init Error:" + e.getMessage());  
	        }  
	    }  
	      
	    public static MyBatisUtil getInstance(DataSource dataSource){  
	        synchronized (dataSource) {  
	            if(myBatisUtil == null){  
	                myBatisUtil = new MyBatisUtil(dataSource);  
	            }  
	        }  
	        return myBatisUtil;  
	    }  
	      
	    public SqlSession getSession() throws Exception{          
	        return sqlSessionFactory.openSession();   
	    }  
}
