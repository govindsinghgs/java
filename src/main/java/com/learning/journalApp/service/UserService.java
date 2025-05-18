package com.learning.journalApp.service;

import com.learning.journalApp.entity.UserEntity;
import com.learning.journalApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<UserEntity> getUserDetails() {
       return userRepo.findAll();
    }

    public UserEntity addUsers(UserEntity myuser) {
        return  userRepo.save(myuser);
    }

    public UserEntity findByUsername(String name) {
      return   userRepo.findByName(name);

    }

    public void saveEntry(UserEntity userIndb) {
        userRepo.save(userIndb);
    }

    public void deleteUser(UserEntity user) {
        userRepo.deleteById(user.getId());
    }
}
