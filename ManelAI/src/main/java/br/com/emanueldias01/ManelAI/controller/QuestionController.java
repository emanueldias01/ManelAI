package br.com.emanueldias01.ManelAI.controller;

import br.com.emanueldias01.ManelAI.model.QuestionUser;
import br.com.emanueldias01.ManelAI.model.ResponseIa;
import br.com.emanueldias01.ManelAI.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ia")
@CrossOrigin("*")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/question")
    public ResponseEntity<ResponseIa> askQuestion(@RequestBody QuestionUser questionUser){
        return ResponseEntity.ok(new ResponseIa(questionService.answersQuestion(questionUser)));
    }
}
