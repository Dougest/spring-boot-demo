/*package com.hola.config;

import java.rmi.server.RemoteServer;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
//import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

*//**
 * NoSQL图数据库
 * @author Dougest 2017年6月3日    上午12:14:18
 *
 *//*
//@Configuration
//@EnableTransactionManagement
//@EnableNeo4jRepositories("com.hola.neo4j")
@Configuration
@EnableNeo4jRepositories(basePackages = "com.hola.neo4j")
@EnableTransactionManagement
public class Neo4jConfig {//extends Neo4jConfiguration {

//	@Override
//	public SessionFactory getSessionFactory() {
//		return new SessionFactory("com.hola.entity.dougest");
//	}

//	@Override
//	public Neo4jServer neo4jServer() {
//		return new RemoteServer("","","");
//	}
//	public Neo4jServer neo4jServer(){
//		return new RemoteServer("http://127.0.0.1:7474","neo4j","zhangxiao");
//	}
//	
//	public SessionFactory getSessionFactory() {
//		return new SessionFactory("com.hola.entity.dougest");
//	}
//	 @Bean
//	 public org.neo4j.ogm.config.Configuration getConfiguration() {
//	       org.neo4j.ogm.config.Configuration config =
//	                new org.neo4j.ogm.config.Configuration();
//      // TODO: Temporary uses the embedded driver. We need to switch to http
//	       // driver. Then we can horizontally scale neo4j
//	       config.driverConfiguration()
//	             .setDriverClassName("org.neo4j.ogm.drivers.embedded.driver.EmbeddedDriver")
//	             .setURI("file:/D:/neo4j/graph.db/");
//	       return config;
//	    }
	 @Bean
	 public SessionFactory sessionFactory() {
	       return new SessionFactory("com.hola.entity.dougest");
	 }

	 @Bean
	 public Neo4jTransactionManager transactionManager() {
	      return new Neo4jTransactionManager(sessionFactory());
	 }
}
*/