package com.primix.respositories;

import org.springframework.data.repository.CrudRepository;
import com.primix.model.exam.Question;

public interface BaseQuestionRepository extends CrudRepository<Question, Integer>{}