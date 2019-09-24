package com.primix.respositories;

import java.util.Optional;
import com.primix.model.exam.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {
    @Query("select w from widget w where lower(w.id) = lower(:id)")
    Optional<Widget> findWidgetById(@Param("id") int id);
}