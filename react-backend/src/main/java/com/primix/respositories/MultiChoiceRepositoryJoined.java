package com.primix.respositories;

import com.primix.model.exam.MultipleChoiceQuestion;
import org.springframework.data.repository.CrudRepository;

public interface MultiChoiceRepositoryJoined extends CrudRepository<MultipleChoiceQuestion, Integer> {}