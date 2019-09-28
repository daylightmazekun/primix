package com.primix.respositories;

import java.util.Optional;
import com.primix.model.exam.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends CrudRepository<Course, Integer>{
    @Query("SELECT c FROM COURSE WHERE LOWER(c.id) = LOWER(:id)")
    Optional<Course> findCourseById(@Param("id") int id);
}