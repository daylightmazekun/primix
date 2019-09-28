package com.primix.respositories;

import java.util.Optional;
import com.primix.model.exam.Assignment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {

    @Query("SELECT a FROM ASSIGNMENT a WHRER LOWER(a.id) = LOWER(:id)")
    Optional<Assignment> findAssignmentById(@Param("id") int id);
}