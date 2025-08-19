package com.example.newboard.web.view;

import com.example.newboard.service.ArticleService;
<<<<<<< HEAD
import com.example.newboard.web.dto.ArticleCreateRequest;
import com.example.newboard.web.dto.ArticleUpdateRequest;
import lombok.RequiredArgsConstructor;
=======
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
=======
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef

@Controller
@RequiredArgsConstructor
public class ArticleViewController {
    private final ArticleService articleService;

    @GetMapping({"/articles"})
<<<<<<< HEAD
    public String list(Model model){
        model.addAttribute("articles", articleService.findAll());
=======
    public String list(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("articlesPage", articleService.findAll(pageable));
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef
        return "article-list";
    }

    @GetMapping("/articles/new")
    public String createForm() { return "article-form";}

<<<<<<< HEAD
//    @PostMapping("/articles")
//    public String create(ArticleCreateRequest req){
//        articleService.create(req);
//        return "redirect:/articles";
//    }

//    @GetMapping("/articles/{id}")
//    public String detail(@PathVariable Long id, Model model){
//        var article = articleService.findById(id);
//        model.addAttribute("article", article);
//        return "article-detail";
//    }

    @GetMapping("/articles/{id}")
    public String detail(@PathVariable Long id, Model model, Authentication auth){
        var article = articleService.findById(id);
        model.addAttribute("article", article);
        boolean isOwner = auth != null && article.getAuthor().getEmail().equals(auth.getName());
=======
    @GetMapping("/articles/{id}")
    public String detail(@PathVariable Long id, Model model, Authentication auth){
        var articleResponse = articleService.findById(id);
        model.addAttribute("article", articleResponse);

        boolean isOwner = auth != null && articleRepository.findById(id)
                .map(article -> article.getAuthor().getEmail().equals(auth.getName()))
                .orElse(false);

>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef
        model.addAttribute("isOwner", isOwner);
        return "article-detail";
    }

    @GetMapping("/articles/{id}/edit")
<<<<<<< HEAD
    public String editForm(@PathVariable Long id, Model model){
        var article = articleService.findById(id);
        model.addAttribute("article", article);
        return "article-edit";
    }

//    @PostMapping("/articles/{id}/edit")
//    public String edit(@PathVariable Long id, ArticleUpdateRequest req){
//        articleService.update(id, req);
//        return "redirect:/articles/" + id; // 수정 후 상세로 이동
//    }

//    @PostMapping("/articles/{id}/delete")
//    public String delete(@PathVariable Long id){
//        articleService.delete(id);
//        return "redirect:/articles";
//    }


}
=======
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
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef
