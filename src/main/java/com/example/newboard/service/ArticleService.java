package com.example.newboard.service;

import com.example.newboard.domain.Article;
import com.example.newboard.repository.ArticleRepository;
import com.example.newboard.repository.UserRepository;
import com.example.newboard.web.dto.ArticleCreateRequest;
<<<<<<< HEAD
import com.example.newboard.web.dto.ArticleUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
=======
import com.example.newboard.web.dto.ArticleDetailResponse;
import com.example.newboard.web.dto.ArticleListViewResponse;
import com.example.newboard.web.dto.ArticleUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

<<<<<<< HEAD
    public List<Article> findAll() {
        return articleRepository.findAll();
=======
    public Page<ArticleListViewResponse> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable).map(ArticleListViewResponse::new);
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef
    }

    @Transactional
    public Long create(ArticleCreateRequest req, String email){
        var author = userRepository.findByEmail(email)
<<<<<<< HEAD
                .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다."));
=======
                .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다. email=" + email));
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef

        return articleRepository.save(
                Article.builder()
                        .title(req.getTitle())
                        .content(req.getContent())
                        .author(author)
                        .build()
        ).getId();
    }


<<<<<<< HEAD
    public Article findById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Article not found:" + id));
    }

    @Transactional
    public void update(Long id, String email, ArticleUpdateRequest req){
        var article = articleRepository.findByIdAndAuthor_Email(id, email)
                .orElseThrow(() -> new AccessDeniedException("본인 글이 아닙니다."));
=======
    public ArticleDetailResponse findById(Long id) {
        var article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. id=" + id));
        return new ArticleDetailResponse(article);
    }

    // 게시글 엔티티를 직접 반환해야 하는 경우 (View Controller에서 사용)
    public Article getArticleForEdit(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. id=" + id));
    }


    @Transactional
    public void update(Long id, String email, ArticleUpdateRequest req){
        var article = articleRepository.findByIdAndAuthor_Email(id, email)
                .orElseThrow(() -> new AccessDeniedException("본인 글이 아니거나, 게시글이 존재하지 않습니다."));
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef

        article.update(req.getTitle(), req.getContent());
    }


    @Transactional
    public void delete(Long id, String email){
<<<<<<< HEAD

        if (articleRepository.deleteByIdAndAuthor_Email(id, email) == 0)
            throw new AccessDeniedException("본인 글이 아닙니다.");
    }
}
=======
        if (articleRepository.deleteByIdAndAuthor_Email(id, email) == 0)
            throw new AccessDeniedException("본인 글이 아니거나, 게시글이 존재하지 않습니다.");
    }
}
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef
