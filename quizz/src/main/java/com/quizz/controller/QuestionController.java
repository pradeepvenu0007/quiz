package com.quizz.controller;

import com.quizz.dto.QuestionDto;
import com.quizz.manager.QuestionManager;
import com.quizz.model.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@Scope("prototype")
public class QuestionController {

    @Autowired
    private QuestionManager questionManager;

    @PostMapping("/addQuestion/{idLevel}")
    Question addQuestion(@RequestBody Question questionDto, @PathVariable("idLevel") Long idLevel) {
        return questionManager.addQuestion(questionDto, idLevel);
    }
    @GetMapping("/getQuestions/{idLevel}")
    List<Question> getQuestions(@PathVariable("idLevel") Long idLevel)  {
        return questionManager.getQuestions(idLevel);
    }
}
