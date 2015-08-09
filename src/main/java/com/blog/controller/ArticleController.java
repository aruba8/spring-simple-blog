package com.blog.controller;

import com.blog.model.Article;
import com.blog.repositories.ArticleRepository;
import com.blog.repositories.TagRepository;
import com.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/")
public class ArticleController {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String listArticles(ModelMap model){
        model.addAttribute("articleList", articleRepository.findAll());
        return "articles";
    }

    @RequestMapping(value = "/addarticle", method = RequestMethod.GET)
    public String addArticlePage(){
        return "addArticle";
    }


    @RequestMapping(value = "/addarticle", method = RequestMethod.POST)
    public String processArticle(@ModelAttribute("article")Article article,
                                 BindingResult result,
                                 Map<String, Object> model){
        if (result.hasErrors()){
            return "articles";
        }

        return "addArticle";
    }

    @RequestMapping(value = "/post/{permalink}")
    public String getArticle(@PathVariable String permalink, Model model){
        Article article = articleRepository.findByPermalink(permalink);
        model.addAttribute("article", article);
        return "article";
    }
}
