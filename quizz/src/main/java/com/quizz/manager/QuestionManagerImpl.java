package com.quizz.manager;

import com.quizz.dao.LevelDao;
import com.quizz.dao.QuestionDao;
import com.quizz.dto.QuestionDto;
import com.quizz.model.Level;
import com.quizz.model.OrikaBeanMapper;
import com.quizz.model.Question;
import com.quizz.servce.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionManagerImpl implements QuestionManager {
	
	 @Autowired
    private QuestionDao questionDao;
	 @Autowired
    private LevelDao levelDao;
	 @Autowired
    private QuestionService questionService;

//    @Autowired
//    public QuestionManagerImpl(OrikaBeanMapper orikaBeanMapper, QuestionDao questionDao, LevelDao levelDao,
//                               QuestionService questionService) {
//        this.orikaBeanMapper = orikaBeanMapper;
//        this.questionDao = questionDao;
//        this.levelDao = levelDao;
//        this.questionService = questionService;
//    }

    @Override
    public Question addQuestion(Question questionDto, Long idLevel) {
        //Question question = orikaBeanMapper.map(questionDto, Question.class);
        Level level = levelDao.getOne(idLevel);
        //return orikaBeanMapper.convertDTO(questionService.addQuestion(question, level), QuestionDto.class);
        return questionService.addQuestion(questionDto, level);
    }

    @Override
    public List<Question> getQuestions(Long idLevel) {
        Level level = levelDao.getOne(idLevel);
        List<Question> questions = level.getQuestions();
       // return orikaBeanMapper.convertListDTO(questions, QuestionDto.class);
        return questions;
    }
}
