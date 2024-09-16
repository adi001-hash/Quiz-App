package com.aditya.quizapp.Service;

import com.aditya.quizapp.DAO.QuestionDao;
import com.aditya.quizapp.DAO.QuizDao;
import com.aditya.quizapp.model.Quiz;
import com.aditya.quizapp.model.Response;
import com.aditya.quizapp.model.allquestions;
import com.aditya.quizapp.model.questionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao dao;

    public ResponseEntity<String> createQuiz(int numQ, String title) {

        List<allquestions>  questions = dao.findRandomQuestion(numQ);
        Quiz quiz = new Quiz();

        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Succes", HttpStatus.CREATED);
    }

    public ResponseEntity<List<questionWrapper>> getQuizQuestion(Integer id) {

       Optional<Quiz> quiz =  quizDao.findById(id);
       List<allquestions> questionFromDB = quiz.get().getQuestions();
       List<questionWrapper> questionForUser = new ArrayList<>();
       for(allquestions q : questionFromDB){
           questionWrapper qw = new questionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
           questionForUser.add(qw);
       }
       return  new ResponseEntity<>(questionForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> getRightAnswer(Integer id, List<Response> response) {

        Quiz quiz = quizDao.findById(id).get();
        List<allquestions> question = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response1 : response){
            if(response1.getResponse().equals(question.get(i).getRight_answer()))
                right++;

            i++;
        }
        return new ResponseEntity<>( right, HttpStatus.OK );
    }
}
