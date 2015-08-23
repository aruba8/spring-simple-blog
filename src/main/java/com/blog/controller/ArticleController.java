package com.blog.controller;

import com.blog.model.Article;
import com.blog.model.Tag;
import com.blog.model.User;
import com.blog.service.ArticleService;
import com.blog.service.TagService;
import com.blog.service.UserService;
import com.blog.utils.ArticleHandler;
import org.hibernate.exception.ConstraintViolationException;
import org.markdown4j.Markdown4jProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class ArticleController {

    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleHandler articleHandler;

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String page403() {
        return "403";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listArticles(ModelMap model) {
        model.addAttribute("articleList", articleService.getArticleList(10));
        return "index";
    }

    @RequestMapping(value = "/addarticle", method = RequestMethod.GET)
    public String addArticlePage() {
        return "addArticle";
    }


    @RequestMapping(value = "/addarticle", method = RequestMethod.POST)
    public String processArticle(@ModelAttribute("article") Article article,
                                 BindingResult result,
                                 Principal principal) {
        if (result.hasErrors()) {
            return "articles";
        }

        Article preparedArticle = articleHandler.prepareArticle(article.getArticleBody());
        User user = userService.getUserByUsername(principal.getName());
        preparedArticle.setAuthor(user);
        tagService.saveTags(preparedArticle.getTags());
        try {
            articleService.saveArticle(preparedArticle);
        } catch (ConstraintViolationException e) {
            return "addArticle";
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/post/{permalink}")
    public String getArticle(@PathVariable String permalink, Model model) throws IOException {
        Article article = articleService.getArticleByPermalink(permalink);
        String htmlArticle = new Markdown4jProcessor().process(article.getArticleBody());
        article.setArticleBody(htmlArticle);
        model.addAttribute("article", article);

        return "article";
    }

    @RequestMapping(value = "/tag", params = {"tag"})
    public String getArticlesByCategory(@ModelAttribute("tag") Tag tag,
                                        BindingResult result,
                                        ModelMap model) throws IOException {

        List<Article> articles = articleService.getArticlesByTag(tag);
        model.addAttribute("articleList", articles);

        return "tag";
    }

}
