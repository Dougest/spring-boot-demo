package com.hola.controller.dougest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hola.entity.dougest.Article;
import com.hola.service.dougest.ArticleService;

import javax.annotation.Resource;
import java.util.List;
/**
 * 默认页面
 * @author Dougest 2017年5月4日    下午10:20:11
 *
 */
@Controller
@RequestMapping("/article")
//@RequestMapping({"/article",""})
public class ArticleController {
//	public ArticleController(){
//		System.out.println("..................................................");
//	}
	@Resource
    private ArticleService articleService;
	
	
    @ResponseBody
    @GetMapping("/get/stage/{stage}")
    public List<Article> getArticleByStage(@PathVariable("stage") Integer stage) throws Exception {
        return articleService.forWeekly(stage);
    }
}
