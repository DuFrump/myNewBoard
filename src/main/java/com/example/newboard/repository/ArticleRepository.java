package com.example.newboard.repository;

import com.example.newboard.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @EntityGraph(attributePaths = "author")
    Optional<Article> findById(Long id);

    @EntityGraph(attributePaths = "author")
    Optional<Article> findByIdAndAuthor_Email(Long id, String email);

    long deleteByIdAndAuthor_Email(Long id, String email);

    // author 정보를 함께 조회하여 N+1 문제를 방지하면서 페이징 처리
    @Override
    @EntityGraph(attributePaths = "author")
    Page<Article> findAll(Pageable pageable);
}