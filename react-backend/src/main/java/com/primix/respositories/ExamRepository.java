package com.primix.respositories;

import java.util.Optional;
import com.primix.model.exam.Exam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ExamRepository extends CrudRepository<Exam, Integer>{
    @Query("SELECT e FROM EXAM e WHERE LOWER(e.id) = LOWER(:id)")
    Optional<Exam> findExamById(@Param("id") int id);
}