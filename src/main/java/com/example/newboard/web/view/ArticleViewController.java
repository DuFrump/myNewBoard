package com.example.newboard.web.view;

import com.example.newboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ArticleViewController {
    private final ArticleService articleService;

    @GetMapping({"/articles"})
    public String list(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("articlesPage", articleService.findAll(pageable));
        return "article-list";
    }

    @GetMapping("/articles/new")
    public String createForm() { return "article-form";}

    @GetMapping("/articles/{id}")
    public String detail(@PathVariable Long id, Model model, Authentication auth){
        var articleResponse = articleService.findById(id);
        model.addAttribute("article", articleResponse);

        boolean isOwner = auth != null && articleRepository.findById(id)
                .map(article -> article.getAuthor().getEmail().equals(auth.getName()))
                .orElse(false);

        model.addAttribute("isOwner", isOwner);
        return "article-detail";
    }

    @GetMapping("/articles/{id}/edit")
    public String editForm(@PathVariable Long id, Model model, Authentication auth){
        // 본인 확인 로직 추가
        var article = articleService.getArticleForEdit(id);
        if (auth == null || !article.getAuthor().getEmail().equals(auth.getName())) {
            throw new AccessDeniedException("수정 권한이 없습니다.");
        }
        model.addAttribute("article", article);
        return "article-edit";
    }
}