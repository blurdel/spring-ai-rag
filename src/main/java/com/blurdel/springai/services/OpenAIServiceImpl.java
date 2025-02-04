package com.blurdel.springai.services;

import com.blurdel.springai.model.Answer;
import com.blurdel.springai.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatModel chatModel;

    @Override
    public Answer getAnswer(Question question) {
        PromptTemplate pt = new PromptTemplate(question.question());
        Prompt prompt = pt.create();
        ChatResponse resp = chatModel.call(prompt);

        return new Answer(resp.getResult().getOutput().getContent());
    }

}
