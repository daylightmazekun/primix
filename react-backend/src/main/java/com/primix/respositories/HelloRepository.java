package com.primix.respositories;

import com.primix.model.exam.Hello;
import org.springframework.data.repository.CrudRepository;

public interface HelloRepository extends CrudRepository<Hello, Integer>{}