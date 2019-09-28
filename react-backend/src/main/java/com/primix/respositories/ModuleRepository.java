package com.primix.respositories;

import java.util.Optional;
import com.primix.model.exam.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ModuleRepository extends CrudRepository<Module, Integer>{
    @Query("SELECT m FROM Module m WHERE LOWER(m.id) = LOWER(:id)")
    Optional<Module> findModuleById(@Param("id") int id);
}