package com.primix.respositories;

import com.primix.model.exam.TrueFalseQuestion;
import org.springframework.data.repository.CrudRepository;

public interface TrueOrFalseQuestionRepositoryJoined extends CrudRepository<TrueFalseQuestion, Integer> {}