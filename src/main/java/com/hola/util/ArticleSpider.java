package com.hola.util;

import java.util.*;

import org.jsoup.Jsoup;
import org.slf4j.*;

import com.hola.component.CsdnWeeklyDocumentAnalyzer;

/**
 * 文章抓取工具
 * @author Dougest 2017年5月4日    下午10:23:37
 *
 */
public class ArticleSpider {
	private static final Logger log = LoggerFactory.getLogger(ArticleSpider.class);

    public static <T> List<T> forEntityList(String url, CsdnWeeklyDocumentAnalyzer docAnalyzer, Class<T> type) throws Exception {

        log.info("开始抓取文章："+url);

        List<T> results = new ArrayList<>();
        docAnalyzer.forListMap(Jsoup.connect(url).timeout(50000).get()).forEach(map->{
            try {
                results.add(TinyUtil.mapToBean(map, type));
            } catch (Exception ignored) {}
         });
        return results;
    }
}
