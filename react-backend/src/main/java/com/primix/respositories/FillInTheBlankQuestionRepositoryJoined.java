package com.primix.respositories;

import com.primix.model.exam.FillInTheBlankExamQuestion;
import org.springframework.data.repository.CrudRepository;

public interface FillInTheBlankQuestionRepositoryJoined extends CrudRepository<FillInTheBlankExamQuestion, Integer> {}