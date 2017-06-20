package com.hola.modelTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hola.config.RedisConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class})
public class RedisTest {
	@Autowired
	RedisTemplate<String,String> redisTemplate;
	
	@Test
	public void test(){
		redisTemplate.opsForValue().set("1", "1");
		
		String a =redisTemplate.opsForValue().get("1");
		System.out.println(a);
	}
}
