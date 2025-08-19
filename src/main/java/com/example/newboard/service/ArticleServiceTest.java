package com.example.newboard.service;

import com.example.newboard.domain.Article;
import com.example.newboard.domain.User;
import com.example.newboard.repository.ArticleRepository;
import com.example.newboard.repository.UserRepository;
import com.example.newboard.web.dto.ArticleCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService articleService;

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("게시글 생성 성공")
    void createArticle_success() {
        // given: 테스트를 위한 준비
        String authorEmail = "test@test.com";
        User author = User.builder().email(authorEmail).name("tester").build();

        ArticleCreateRequest request = new ArticleCreateRequest();
        request.setTitle("테스트 제목");
        request.setContent("테스트 내용");

        Article savedArticle = Article.builder()
                .id(1L)
                .title(request.getTitle())
                .content(request.getContent())
                .author(author)
                .build();

        // Mocking: userRepository와 articleRepository의 동작을 미리 정의
        when(userRepository.findByEmail(authorEmail)).thenReturn(Optional.of(author));
        when(articleRepository.save(any(Article.class))).thenReturn(savedArticle);

        // when: 실제 테스트하려는 메서드 호출
        Long createdId = articleService.create(request, authorEmail);

        // then: 결과 검증
        assertThat(createdId).isEqualTo(1L);
    }
}