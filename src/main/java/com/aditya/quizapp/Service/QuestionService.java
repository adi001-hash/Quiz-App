package com.aditya.quizapp.Service;

import com.aditya.quizapp.DAO.QuestionDao;
import com.aditya.quizapp.model.allquestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
     @Autowired
     QuestionDao dao;
    public List<allquestions> getAllQuestion() {
         return  dao.findAll();

    }

    public List<allquestions> searchByDifficultyLevel(String difficultyLevel) {
        return dao.findBydifficultyLevel(difficultyLevel);
    }

    public String addQuestion(allquestions questions) {

        dao.save(questions);
        return "success";
    }
}
