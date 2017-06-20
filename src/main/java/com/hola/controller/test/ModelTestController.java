package com.hola.controller.test;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
//import com.hola.entity.dougest.Actor;
import com.hola.entity.dougest.Message;
//import com.hola.entity.dougest.Movie;
//import com.hola.mongo.MessageMondoDBDao;
//import com.hola.neo4j.MovieDao;
/**
 * 单元类/模块/组件测试接口
 * @author Dougest 2017年6月2日    下午10:02:42
 *
 */
@Controller//为了返回一些需要的页面,不适用RestController
@RequestMapping(value="/test")
public class ModelTestController {
	@Autowired
	RedisTemplate<String,String> redisTemplate;
	//@Autowired
	//MessageMondoDBDao messageMondoDBDao;
	//@Autowired
	//MovieDao movieDao;
	
//	@RequestMapping("/neo4j")
//	@ResponseBody
//	public String neo4jTest(){
//		movieDao.deleteAll();
//		
//		Movie m1 = new Movie();
//		m1.setTitle("黄飞鸿");
//		m1.setYear("1994-07-05");
//		
//		Movie m2 = new Movie();
//		m2.setTitle("霍元甲");
//		m2.setYear("2010-01-02");
//		
//		Movie m3 = new Movie();
//		m3.setTitle("岁月神偷");
//		m3.setYear("2005-12-23");
//		
//		Actor a1 = new Actor();
//		a1.setName("李连杰");
//		
//		Actor a2 = new Actor();
//		a2.setName("成龙");
//		
//		Actor a3 = new Actor();
//		a3.setName("刘德华");
//		
//		m1.addRole(a1, "女主角");
//		m1.addRole(a2, "武术导演");
//		m1.addRole(a3, "主角");
//		movieDao.save(m1);
//		
//		m2.addRole(a1, "主演");
//		m2.addRole(a2, "编剧");
//		m2.addRole(a3, "配角");
//		movieDao.save(m2);
//		
//		m3.addRole(a1, "路人甲");
//		m3.addRole(a2, "大反派");
//		m3.addRole(a3, "特约演员");
//		movieDao.save(m3);
//		
//		Gson json = new Gson();
//		
//		return json.toJson(movieDao.findAll());
//	}
	/**
	 * redis
	 * success!
	 * @return
	 */
	@RequestMapping("/redis")
	@ResponseBody
	public String redisTest(){
		redisTemplate.opsForValue().set("1", "how are you");
		String a = redisTemplate.opsForValue().get("1");
		return a;
	}
	/**
	 * @return
	 * 安装太费事了,难的一笔
	 */
//	@RequestMapping("/mongoDB")
//	@ResponseBody
//	public String MondoDBTest(){
//		Message m = new Message();
//		m.setId(1l);
//		m.setContent("hola");
//		m.setCreatTime(new Date());
//		m.setIp(123l);
//		m.setUserAgent("chrome");
//		messageMondoDBDao.save(m);
//		Gson json = new Gson();
//		return json.toJson(messageMondoDBDao.findAll());
//	}
	/**
	 * @return
	 * 安装太费事了,难的一笔
	 */
//	@RequestMapping("/mongoDBAll")
//	@ResponseBody
//	public String MondoDBTestAll(){
//		Gson json = new Gson();
//		return json.toJson(messageMondoDBDao.findAll());
//	}
	/**
	 * 页面一定要有 <%@ page isELIgnored="false" %>
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/jspmodel")
	public String test(Model model){
		model.addAttribute("hello", "world");
		model.addAttribute("hola", "adios");
		return "test";
	}
	 @RequestMapping("/jspmmap")
	  public String helloJsp(Map<String, Object> map) {
	      map.put("hello", "world");
	      map.put("hola", "adios");
	      return "test";
	  }
}