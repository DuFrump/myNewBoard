package com.example.newboard.web.view;

import com.example.newboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
=======
import org.springframework.http.ResponseEntity;
>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProbeController {
    private final ArticleRepository repo;

<<<<<<< HEAD
=======
    @GetMapping("/probe/live")
    public ResponseEntity<String> live() {
        return ResponseEntity.ok("OK");
    }

>>>>>>> b021dbcb03e163f9d23301eca69633e2b08d60ef
    @GetMapping("/probe/count")
    public long count(){ return repo.count(); }
}
