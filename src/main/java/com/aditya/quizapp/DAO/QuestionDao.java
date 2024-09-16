package com.aditya.quizapp.DAO;

import com.aditya.quizapp.model.allquestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<allquestions, Integer> {
    public List<allquestions> findBydifficultyLevel(String difficultyLevel);
  @Query(value = "SELECT * FROM allquestions ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<allquestions> findRandomQuestion(int numQ);
}
