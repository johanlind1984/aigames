package com.lindbros.aigames.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IveNeverService {

    @Value("spring.application.openai.key")
    private String openAiKey;

    public String sendToChatGpt(String language, String category) {
        ChatLanguageModel model = OpenAiChatModel.builder()
                .apiKey(openAiKey)
                .modelName(OpenAiChatModelName.GPT_4_TURBO_PREVIEW)
                .build();

        model.chat(String.format("""
        This is a computer service that just expects the statement in response.
        Just respond with the statement. Nothing else.
        
        Please give me a i've never statement within the category %s
        and the response should be in %s.
        """, category, language));

        return model.generate().content().text();
    }
}
