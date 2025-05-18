package com.learning.journalApp.repository;

import com.learning.journalApp.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserEntity,String> {
    UserEntity findByName(String name);
}
