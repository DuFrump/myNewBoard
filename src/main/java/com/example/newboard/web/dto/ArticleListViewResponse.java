package com.example.newboard.web.dto;

<<<<<<< HEAD
public class ArticleListViewResponse {
}
=======
import com.example.newboard.domain.Article;
import lombok.Getter;

@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
    }
}
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef
