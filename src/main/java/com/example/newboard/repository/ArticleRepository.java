package com.example.newboard.repository;

import com.example.newboard.domain.Article;
<<<<<<< HEAD
=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @EntityGraph(attributePaths = "author")
    Optional<Article> findById(Long id);

    @EntityGraph(attributePaths = "author")
    Optional<Article> findByIdAndAuthor_Email(Long id, String email);

    long deleteByIdAndAuthor_Email(Long id, String email);
<<<<<<< HEAD
}


// CRUD
// findAll()
=======

    // author 정보를 함께 조회하여 N+1 문제를 방지하면서 페이징 처리
    @Override
    @EntityGraph(attributePaths = "author")
    Page<Article> findAll(Pageable pageable);
}
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef
