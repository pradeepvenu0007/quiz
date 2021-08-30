package com.quizz.manager;

import com.quizz.dto.QuestionDto;
import com.quizz.model.Question;

import java.util.List;

public interface QuestionManager {

     Question addQuestion(Question questionDto, Long idLevel);

     List<Question> getQuestions(Long idLevel);
}
