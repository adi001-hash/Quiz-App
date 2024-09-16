package com.aditya.quizapp.Controller;

import com.aditya.quizapp.Service.QuestionService;
import com.aditya.quizapp.model.allquestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestion")
    public List<allquestions> getAllQuestion(){
        return questionService.getAllQuestion();
    }
    @GetMapping("level/{difficultyLevel}")
    public List<allquestions> searchByLevel(@PathVariable String difficultyLevel){
        return questionService.searchByDifficultyLevel(difficultyLevel);
    }
     @PostMapping("add")
    public String addQuestion( @RequestBody allquestions questions){

        return questionService.addQuestion(questions);
    }


}
