package com.learning.journalApp.controller;


import com.learning.journalApp.entity.UserEntity;
import com.learning.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers(){
      List<UserEntity> ue =  userService.getUserDetails();
        return new ResponseEntity<>(ue,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserEntity> addUsers(@RequestBody UserEntity myuser){
        userService.addUsers(myuser);
        return  new ResponseEntity<>(myuser,HttpStatus.OK);
    }
    @PutMapping("/{name}")
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user , @PathVariable String name){
       UserEntity userIndb =  userService.findByUsername(name);
       if(userIndb!=null){
           userIndb.setName(user.getName());
           userIndb.setPassword(user.getPassword());
           userService.saveEntry(userIndb);
       }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody UserEntity user){
        userService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
