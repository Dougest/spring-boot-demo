package com.hola.service.dougest;

import java.util.List;

import com.hola.entity.dougest.Article;

/**
 * 文章service实现
 * @author Dougest 2017年5月4日    下午10:16:09
 *
 */
public interface ArticleService {
	/**
     * 根据期号获取文章列表
     * @param stage 期号
     * @return 文章列表
     */
    List<Article> forWeekly(Integer stage) throws Exception;
}
