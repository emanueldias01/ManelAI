package br.com.emanueldias01.ManelAI.controller;

import br.com.emanueldias01.ManelAI.model.QuestionUser;
import br.com.emanueldias01.ManelAI.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ia")
@CrossOrigin("*")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/question")
    public ResponseEntity<Flux<String>> askQuestion(@RequestBody QuestionUser questionUser){
        return ResponseEntity.ok(questionService.answersQuestion(questionUser));
    }
}
