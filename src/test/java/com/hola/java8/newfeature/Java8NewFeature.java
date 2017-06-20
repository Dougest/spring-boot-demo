package com.hola.java8.newfeature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Clock;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.hola.util.HttpKit;

public class Java8NewFeature {
	
//	Duck duck;
	String url = null;
	@Before
	public void init() {
		/*duck = new DuckImpl();
		System.out.println("start ... ");*/
		url = "http://www.baidu.com";
		
	}
	
	/**
	 * 接口的默认方法,实现类可以覆盖
	 * 
	 * result:嘎嘎嘎...
	 * result:2
	 * @throws IOException 
	 */ 
//	@Test@Ignore
//	public void test1(){
//		duck.shout();
//		System.out.println(duck.eat());
//		Duck.run(1);
//	}
	@Test//@Ignore //原生
	//耗时   7076 6574
	public void test2() throws IOException {
		Long start = System.currentTimeMillis();
		for(int i = 0; i<1*100;i++) {
			URL url = new URL("http://www.baidu.com"); 
			URLConnection conn = url.openConnection(); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			String line = null; 
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
		
		Long end = System.currentTimeMillis(); 
		System.out.println(end-start);
		
	}  
	
	@Test@Ignore //HttpKit(封装的方法)
	//耗时 6856  6887  9803 9893
	public void test3() throws IOException {
		Long start = System.currentTimeMillis();
		for(int i = 0; i<1*100;i++) {
			String html = HttpKit.get(url,null,null);
			System.out.println(html);
		}
		Long end = System.currentTimeMillis(); 
		System.out.println(end-start);
	}  
	@Test@Ignore//jsoup
	//耗时 21813  21622
	public void test4() throws IOException {
		Long start = System.currentTimeMillis();
		for(int i = 0; i<1*100;i++) {
			 Document  doc = Jsoup.connect(url).timeout(10*1000).get();;
			System.out.println(doc.html());
		}
		Long end = System.currentTimeMillis(); 
		System.out.println(end-start);
	}  
	
}
