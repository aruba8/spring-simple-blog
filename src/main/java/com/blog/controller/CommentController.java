package com.blog.controller;

import com.blog.model.Article;
import com.blog.model.Comment;
import com.blog.service.ArticleService;
import com.blog.service.CommentService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addcomment", method = RequestMethod.POST, params = {"article_id", "comment"})
    public RedirectView addComment(@RequestParam(value = "article_id") String article_id,
                             @RequestParam(value = "comment") String comment,
                             Principal principal) {

        String username = principal.getName();
        Article currentArticle = articleService.getArticleById(Long.parseLong(article_id));
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/post/"+currentArticle.getPermalink());

        if (comment.equals("") || comment.trim().length() < 1 ){
            return redirectView;
        }


        Comment newComment = new Comment();
        newComment.setAuthor(userService.getUserByUsername(username));
        newComment.setArticle(currentArticle);
        newComment.setComment(comment);
        newComment.setDateTime(new Date());
        commentService.save(newComment);

        return redirectView;
    }
}
