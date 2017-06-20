package com.hola.jsoup;

import java.io.IOException;
import java.util.List;
import java.util.Random;

//import org.apdplat.word.WordSegmenter;
//import org.apdplat.word.segmentation.Word;
//import org.apdplat.word.tagging.AntonymTagging;
//import org.apdplat.word.tagging.PartOfSpeechTagging;
//import org.apdplat.word.tagging.SynonymTagging;
import org.junit.Ignore;
//import org.apdplat.word.WordSegmenter;
//import org.apdplat.word.segmentation.Word;
//import org.apdplat.word.tagging.AntonymTagging;
//import org.apdplat.word.tagging.PartOfSpeechTagging;
//import org.apdplat.word.tagging.SynonymTagging;
//import org.junit.Ignore;
import org.junit.Test;

import com.hola.util.HttpKit;

public class HttpKitTest {
	/**
	 * API https://github.com/ysc/word
	 */
	@Test@Ignore 
    public void test1()  {
//		List<Word> words = WordSegmenter.segWithStopWords("中华人民共和国万岁");
//		System.out.println("未标注词性："+words);
//		//词性标注
////		PartOfSpeechTagging.process(words);
////		System.out.println("标注词性："+words);
//		//开启同义词
//		SynonymTagging.process(words, false);
//		System.out.println("同义："+words);
//		//反义
//		AntonymTagging.process(words);
//		System.out.println("反义："+words);
//		List<Word> words = WordSegmenter.segWithStopWords("中华人民共和国万岁");
//		System.out.println("未标注词性："+words);
		//词性标注
//		PartOfSpeechTagging.process(words);
//		System.out.println("标注词性："+words);
		//开启同义词
	//	SynonymTagging.process(words, false);
//		System.out.println("同义："+words);
		//反义
	//	AntonymTagging.process(words);
//		System.out.println("反义："+words);
    }  
	
	@Test@Ignore //HttpKit(封装的方法)
    //耗时 6856  6887  9803 9893 3429 1402
    public void test3() throws IOException {
		String url = "http://www.baidu.com/";
        Long start = System.currentTimeMillis();
        for(int i = 0; i<1*100;i++) {
            String html = HttpKit.get(url,null,null);
            System.out.println(html);
            System.out.println(i++);
        }
        Long end = System.currentTimeMillis(); 
        System.out.println(end-start);
    }  
	
	@Test@Ignore
	public void test4() {
		for(int i = 0; i< 1000; i++) {
			int radomInt = (int) ((Math.random()*9+1)*100000);//6位数
			System.out.println("int "+radomInt);
			System.out.println((int)((Math.random()*9+1)*10000));//五位数  
			System.out.println((int)((Math.random()*9+1)*1000));  //4位数
		}
	}
	@Test
	public void test5(){
		/**
		 * 测试 
		 * 实际的需求你可以看文档自己实现
		 * 注意!!!!
		 * ak是我个人申请的,不要用于企业实际开发,
		 */
		//百度地图文档地址 http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-placeapi
		String url = "http://api.map.baidu.com/place/v2/search?q=饭店&region=苏州&output=json&ak=UzbxCuAwAPfi1gDwWbEbiZKVeLwrbHbV";
		String result = HttpKit.get(url,null,null);
		System.out.println(result);
		//返回结果如下
//		{
//		    "status":0,
//		    "message":"ok",
//		    "results":[
//		        {
//		            "name":"苏州苏苑饭店",
//		            "location":{
//		                "lat":31.279794,
//		                "lng":120.635792
//		            },
//		            "address":"吴中区东吴北路130号（紧邻苏苑街）",
//		            "street_id":"85403b036d8b5327fbdc8515",
//		            "telephone":"0512-66018888",
//		            "detail":1,
//		            "uid":"b3aa435db87e781215764367"
//		        },
//		        {
//		            "name":"南林饭店",
//		            "location":{
//		                "lat":31.306079,
//		                "lng":120.635626
//		            },
//		            "address":"姑苏区十全街滚绣坊20号（网师园西100米）",
//		            "street_id":"2848ffd61d6f731648cc4a4f",
//		            "telephone":"(0512)68017888",
//		            "detail":1,
//		            "uid":"2848ffd61d6f731648cc4a4f"
//		        },
//		        {
//		            "name":"同里湖大饭店",
//		            "location":{
//		                "lat":31.169623,
//		                "lng":120.734761
//		            },
//		            "address":"苏州吴江区同里九里湖路8号",
//		            "street_id":"24d0550879b95ab6128824c4",
//		            "telephone":"(0512)63337888",
//		            "detail":1,
//		            "uid":"24d0550879b95ab6128824c4"
//		        },
//		        {
//		            "name":"香雪海饭店胥江店",
//		            "location":{
//		                "lat":31.295144,
//		                "lng":120.611891
//		            },
//		            "address":"胥江路271号(近地铁2号线胥江路站3号出口)",
//		            "street_id":"c165340545af8d60aa175a83",
//		            "telephone":"(0512)68228888",
//		            "detail":1,
//		            "uid":"c165340545af8d60aa175a83"
//		        },
//		        {
//		            "name":"金鸡湖大酒店",
//		            "location":{
//		                "lat":31.291632,
//		                "lng":120.720856
//		            },
//		            "address":"苏州工业园区国宾路168号(苏州工业园区金鸡湖商业区,近机场路)",
//		            "street_id":"5b25f4463f6b61f310293545",
//		            "telephone":"0512-62887878",
//		            "detail":1,
//		            "uid":"5b25f4463f6b61f310293545"
//		        },
//		        {
//		            "name":"中华园大饭店",
//		            "location":{
//		                "lat":31.2796,
//		                "lng":120.523258
//		            },
//		            "address":"苏州市吴中区木渎金山路198号(与竹园路交汇处)",
//		            "street_id":"cd9d05dd737e06af84420e9b",
//		            "telephone":"0512-66256666",
//		            "detail":1,
//		            "uid":"cd9d05dd737e06af84420e9b"
//		        },
//		        {
//		            "name":"昆山商贸饭店",
//		            "location":{
//		                "lat":31.389033,
//		                "lng":120.975001
//		            },
//		            "address":"前进中路387号瑞士大酒店1楼",
//		            "street_id":"4cf8d24eb2953dfd9cf77979",
//		            "telephone":"(0512)57885788",
//		            "detail":1,
//		            "uid":"4cf8d24eb2953dfd9cf77979"
//		        },
//		        {
//		            "name":"国际饭店",
//		            "location":{
//		                "lat":31.677553,
//		                "lng":120.733658
//		            },
//		            "address":"苏州常熟市黄河路288号",
//		            "street_id":"cc0849a0300b18499403194b",
//		            "telephone":"(0512)52101888",
//		            "detail":1,
//		            "uid":"cc0849a0300b18499403194b"
//		        },
//		        {
//		            "name":"华侨饭店",
//		            "location":{
//		                "lat":31.306051,
//		                "lng":120.607667
//		            },
//		            "address":"苏州金阊区三香路178号华侨饭店2楼",
//		            "street_id":"cc788fde7cb3d69388fc0679",
//		            "telephone":"(0512)67138939,(0512)67138929",
//		            "detail":1,
//		            "uid":"cc788fde7cb3d69388fc0679"
//		        },
//		        {
//		            "name":"松陵饭店",
//		            "location":{
//		                "lat":31.166811,
//		                "lng":120.650522
//		            },
//		            "address":"吴江松陵镇中山北路51号（近万亚广场）",
//		            "street_id":"2c0bd6c543ddddb342ab9aac",
//		            "telephone":"(0512)63472888",
//		            "detail":1,
//		            "uid":"2c0bd6c543ddddb342ab9aac"
//		        }
//		    ]
//		}
	}
	
	
}
