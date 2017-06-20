package com.hola.config;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * Druid是一个关系型数据库连接池,支持所有JDBC兼容的数据库,在监控,可扩展性,稳定性和性能方面
 * 具有明显优势.通过Druid提供的监控功能,可以实时观察数据库连接池和SQL查询工作情况
 * 使用它可以在一定程度上提高数据库访问性能
 * @author Dougest 2017年5月7日    下午6:11:52
 *	程序启动后,访问 http://localhost/HolaFramwork/druid/login.html
 */
@Configuration
public class DatasourceConfig {
	@Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
	@Bean
	public ServletRegistrationBean statViewServle(){
		ServletRegistrationBean servletRegistrationBean = 
				new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1");//白名单
		servletRegistrationBean.addInitParameter("deny", "192.168.1.10");//黑名单 共同存在时,deny优先与allow
		servletRegistrationBean.addInitParameter("loginUsername", "hola");
		servletRegistrationBean.addInitParameter("loginPassword", "123");
		servletRegistrationBean.addInitParameter("resetEnable", "false");//是否能够重置数据
		return servletRegistrationBean;
	}
	
	@Bean
	public FilterRegistrationBean statFilter() {
		FilterRegistrationBean filterRegistrationBean  = new FilterRegistrationBean(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
