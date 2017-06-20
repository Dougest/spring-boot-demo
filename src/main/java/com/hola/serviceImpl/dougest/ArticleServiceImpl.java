package com.hola.serviceImpl.dougest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hola.component.CsdnWeeklyDocumentAnalyzer;
import com.hola.entity.dougest.Article;
import com.hola.service.dougest.ArticleService;
import com.hola.util.ArticleSpider;
@Service
public class ArticleServiceImpl implements ArticleService {
	 	
		@Value("${csdn.weekly.preurl}")
	    private String preUrl;
		
	    @Resource
	    private CsdnWeeklyDocumentAnalyzer csdnWeeklyDocumentAnalyzer;
	    /**
	     * 根据期号获取文章列表
	     *
	     * @param stage 期号
	     * @return 文章列表
	     */
	    @Override
	    @Cacheable(value = "reportcache", keyGenerator = "csdnKeyGenerator")
	    public List<Article> forWeekly(Integer stage) throws Exception {
	        List<Article> articleList = ArticleSpider.forEntityList(preUrl + stage, csdnWeeklyDocumentAnalyzer, Article.class);
	        articleList.forEach(article -> article.setStage(stage));
	        return articleList;
	    }
}
