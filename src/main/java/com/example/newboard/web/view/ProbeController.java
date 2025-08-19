package com.example.newboard.web.view;

import com.example.newboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProbeController {
    private final ArticleRepository repo;

    @GetMapping("/probe/live")
    public ResponseEntity<String> live() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/probe/count")
    public long count(){ return repo.count(); }
}
