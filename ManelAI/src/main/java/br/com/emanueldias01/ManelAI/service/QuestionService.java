package br.com.emanueldias01.ManelAI.service;

import br.com.emanueldias01.ManelAI.model.QuestionUser;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final ChatClient chatClient;

    public QuestionService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public String answersQuestion(QuestionUser questionUser){
        return chatClient.prompt()
                .user(questionUser.prompt())
                .call()
                .content();
    }
}
