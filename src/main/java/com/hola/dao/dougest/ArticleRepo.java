package com.hola.dao.dougest;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hola.entity.dougest.Article;
/**
 * 文章数据访问层
 * @author Dougest 2017年5月4日    下午10:28:08
 *
 */
public interface ArticleRepo extends JpaRepository<Article, Long>{

}
