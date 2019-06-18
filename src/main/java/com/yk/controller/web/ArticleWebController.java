package com.yk.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("web/article")
@Controller
public class ArticleWebController {

    @GetMapping("/add")
    public String addArticle() {
        return "article/add";
    }

    /**
     * 返回文章页面
     *
     * @return
     */
    @GetMapping("/list")
    public String articleList() {
        return "article/list";
    }

    /**
     * 返回文章页面
     *
     * @return
     */
    @GetMapping("/update")
    public ModelAndView update(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("article/update");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

}
