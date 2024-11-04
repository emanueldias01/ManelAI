package br.com.emanueldias01.ManelAI.service;

import br.com.emanueldias01.ManelAI.model.QuestionUser;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final ChatClient chatClient;

    @Value("default.system")
    private String systemDefaultPrompt;

    public QuestionService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient
                .defaultSystem(systemDefaultPrompt)
                .build();
    }

    public String answersQuestion(QuestionUser questionUser){
        return chatClient.prompt()
                .user(questionUser.prompt())
                .call()
                .content();
    }
}
