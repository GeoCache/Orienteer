package com.orienteer.orienteer.repositories;

import com.orienteer.orienteer.models.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long> {

   List<User> findAll();
   User findUserByUserName(String username);
   User findUsersById(long id);

}
