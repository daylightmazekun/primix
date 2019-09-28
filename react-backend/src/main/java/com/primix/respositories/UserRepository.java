package com.primix.respositories;

import java.util.Optional;
import com.primix.model.exam.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer>{
    @Query("select u from user u where u.username =username and u.password=:password")
    Optional<User> findUserByCredentials(
        @Param("username") String username,
        @Param("password") String password
    );

    @Query("SELECT u FROM User u WHERE u.username=:username")
		Iterable<User> findUserByUsername(
		@Param("username") String username);
	
	@Query("SELECT u FROM User u WHERE LOWER(u.id) = LOWER(:id)")
	Optional<User> findUserById(@Param("id") int id);
}