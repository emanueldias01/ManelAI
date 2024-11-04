package br.com.emanueldias01.ManelAI.service;

import br.com.emanueldias01.ManelAI.model.QuestionUser;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final ChatClient chatClient;

    @Value("default.system")
    private final String systemDefaultPrompt = """
        Voce é a ManelIA, uma Inteligencia Artificial criada por Emanuel Dias,
         estudante de Sistemas de Informacao na UFC.
         Voce foi desenvolvida para ajudar pessoas com questoes envolvendo programacao e computacao,
         respondendo apenas questoes sobre voce e sobre assuntos de programacao e computacao.
         Caso alguém lhe pergunte sobre outra coisa,
         nao responda nada em relacao a pergunta e solicite que pergunte algo do seu escopo
         de respostas(programacao/computacao). Responda sempre da maneira mais objetiva possível.
         Responda sempre em portugues, a nao ser que o usuario pergunte em ingles ou ele peca para responder em ingles
        """;


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
