/*package com.hola.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
*//**
 * 安装教程  http://www.cnblogs.com/dougest/p/6939777.html
 * @author Dougest 2017年6月4日    上午10:44:27
 * mongoDB是文档型数据库,使用他也可以像关系型数据库那样为文档建模
 * NoSQL数据库之一,具有大数据量,高并发的优势
 * 缺点是不能建立实体关系,也没有事物管理机制
 *//*
@Configuration
@EnableMongoRepositories(basePackages = "com.hola.mongo")
@PropertySource("classpath:application.properties")
public class MongoDBConfig extends AbstractMongoConfiguration{
	@Autowired
	private Environment env;

	protected String getDatabaseName() {
		return env.getRequiredProperty("mongo.name");
	}
	@Bean
	public Mongo mongo() throws Exception {
		ServerAddress serverAddress = new ServerAddress(env.getRequiredProperty("mongo.host"));
		List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		return new MongoClient(serverAddress,credentials);
	}

}
*/