package com.aditya.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class allquestions {

    @Id
   
    private Integer id;
    @Column(name = "difficulty_level") // or @Column(name = "difficultyLevel") if using camel case
    private String difficultyLevel;
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String right_answer;
}
