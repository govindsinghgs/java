package com.learning.journalApp.controller;

import com.learning.journalApp.entity.JournalEntity;
import com.learning.journalApp.entity.UserEntity;
import com.learning.journalApp.service.JournalEntryService;
import com.learning.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;


    @GetMapping("{username}")
    public ResponseEntity<List<JournalEntity>> getDetails(@PathVariable String username){
        UserEntity byUsername = userService.findByUsername(username);
        List<JournalEntity> je = journalEntryService.getDetails();
        if(je!=null || byUsername!=null){
            return  new ResponseEntity<>(HttpStatus.OK);
        }
       return new ResponseEntity<>(journalEntryService.getDetails(), HttpStatus.OK);
    }

    @PostMapping("{username}")
    public ResponseEntity<JournalEntity> saveData(@RequestBody JournalEntity myEntity,@PathVariable String username){
        journalEntryService.saveEntry(myEntity,username);
        return new ResponseEntity<>( myEntity,HttpStatus.CREATED);
    }
    @DeleteMapping("{username}")
    public ResponseEntity<String> deleteData(@RequestBody String id,@PathVariable String username){
        journalEntryService.deleteEntry(id,username);
        return new ResponseEntity<>("Data Delete Sucess",HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<String> updateData(@RequestBody JournalEntity journalEntity){
        journalEntryService.updateDetails(journalEntity);
        return new ResponseEntity<>("Data update Success",HttpStatus.OK);
    }

}
