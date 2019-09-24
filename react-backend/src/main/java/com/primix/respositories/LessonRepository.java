package com.primix.respositories;

import java.util.Optional;
import com.primix.model.exam.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LessonRepository extends CrudRepository<Lesson, Integer>{
    @Query("SELECT l from Lesson l WHERE LOWER(l.id) = LOWER(:id)")
    Optional<Lesson> findLessonById(@Param("id") int id);
}