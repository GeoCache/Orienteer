package com.orienteer.orienteer.repositories;

import com.orienteer.orienteer.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {

    User findByUsername(String username);

    @Query(nativeQuery = true, value = "SELECT * FROM users LIMIT 1")
    User first();

    User findUserByEmail(String Email);
}