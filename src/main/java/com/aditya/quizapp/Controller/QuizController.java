package com.aditya.quizapp.Controller;

import com.aditya.quizapp.Service.QuizService;
import com.aditya.quizapp.model.Response;
import com.aditya.quizapp.model.questionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam int numQ, @RequestParam String title){
     return quizService.createQuiz(numQ, title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<questionWrapper>> getQuizQuestion(@PathVariable  Integer id){

      return  quizService.getQuizQuestion(id);

    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody  List<Response> response){
       return quizService.getRightAnswer(id,response);
    }
}
