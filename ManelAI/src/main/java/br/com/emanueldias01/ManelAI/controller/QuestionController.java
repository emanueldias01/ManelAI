package br.com.emanueldias01.ManelAI.controller;

import br.com.emanueldias01.ManelAI.model.QuestionUser;
import br.com.emanueldias01.ManelAI.service.QuestionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ia")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/question")
    public String askQuestion(@RequestBody QuestionUser questionUser){
        return questionService.answersQuestion(questionUser);
    }
}
