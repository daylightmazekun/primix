package com.primix.respositories;

import org.springframework.data.repository.CrudRepository;

public interface ExamRepository extends CrudRepository<Exam, Integer>{
    @Query("SELECT e FROM EXAM e WHERE LOWER(e.id) = LOWER(:id)");
}