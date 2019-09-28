package com.primix.respositories;

import com.primix.model.exam.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {}