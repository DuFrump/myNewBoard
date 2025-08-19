package com.example.newboard.web.dto;

import com.example.newboard.domain.Article;
import lombok.Getter;

@Getter
public class ArticleDetailResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String authorName;

    public ArticleDetailResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.authorName = article.getAuthor().getName();
    }
}