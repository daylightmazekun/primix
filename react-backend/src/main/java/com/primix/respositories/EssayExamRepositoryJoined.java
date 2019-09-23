package com.primix.respositories;

import com.primix.model.exam.EssayExamQuestion;
import org.springframework.data.repository.CrudRepository;

public interface EssayExamRepositoryJoined extends CrudRepository<EssayExamQuestion, Integer>{}