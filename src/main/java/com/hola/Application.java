package com.hola;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 */

@SpringBootApplication
@EnableScheduling//@EnableScheduling 注解的作用是发现注解@Scheduled的任务并后台执行.
//@ServletComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.hola.dao.dougest")  
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
