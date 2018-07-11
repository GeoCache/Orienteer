package com.orienteer.orienteer.services;


import com.orienteer.orienteer.models.User;
import org.springframework.stereotype.Service;
import com.orienteer.orienteer.repositories.UsersRepository;

import java.util.List;
import java.util.Random;

@Service
public class UserServices {

    private UsersRepository userDao;

    public UserServices(UsersRepository userDao) {
        this.userDao = userDao;
    }

    public User findRandomUser() {
        List<User> users = userDao.findAll();
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }

    public User save (User user) {
        return userDao.save(user);
    }


}
