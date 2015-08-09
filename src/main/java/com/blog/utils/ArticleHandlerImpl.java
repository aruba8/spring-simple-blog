package com.blog.utils;

import com.blog.model.Article;
import com.blog.model.Tag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ArticleHandlerImpl implements ArticleHandler {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

    @Override
    public Article prepareArticle(String rawArticle) {
        String splitRawPost [] = rawArticle.split("~~~~~~~~~~~~~~");
        String head = splitRawPost[0];
        String body = splitRawPost[1];
        String title = "";
        String isCommentsAvailable = "";
        String splitHead [] = head.split("\n|\r\n");
        String dateString = "";
        String tagNames[] = null;
        Set<Tag> tagSet = new HashSet<>();
        for (String aSplitHead : splitHead) {
            if (aSplitHead.startsWith("Title:")) {
                title = aSplitHead.replace("Title:", "").trim();
            } else if (aSplitHead.startsWith("Date:")) {
                dateString = aSplitHead.replace("Date:", "").toLowerCase().trim();
            } else if (aSplitHead.startsWith("Comments:")) {
                isCommentsAvailable = aSplitHead.replace("Comments:", "").toLowerCase().trim();
            } else if (aSplitHead.startsWith("Categories:")){
                tagNames = aSplitHead.replace("Categories:", "").split(",");
                for (String tagName : tagNames){
                    tagSet.add(new Tag(tagName));
                }
            }
        }
        Article article = new Article();
        article.setTags(tagSet);

        try {
            if (dateString.equals("")){
                article.setDateTime(new Date());
            }else {
                article.setDateTime(dateFormat.parse(dateString));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        article.setTitle(title);
        article.setArticleBody(body);
        article.setPermalink(createPermalink(title));
        return article;
    }

    private static String createPermalink(String title){
        String titleInTranslit = Translit.toTranslit(title);
        String permalink = titleInTranslit.replaceAll("\\s", "-");
        permalink = permalink.replaceAll("\\W", "-");
        permalink = permalink.toLowerCase();
        if (permalink.length() > 60) {
            return permalink.substring(0, 60);
        } else {
            return permalink;
        }
    }

}
