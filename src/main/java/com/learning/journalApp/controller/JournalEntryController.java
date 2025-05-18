package com.learning.journalApp.controller;

import com.learning.journalApp.entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
//    private Map<Long, JournalEntity> journalEntityMap = new HashMap<>();
//
//   @GetMapping("/details")
//   public String getAll(){
//        return journalEntityMap.values().toString();
//    }
//
//    @PostMapping
//    public String adddetails(@RequestBody JournalEntity myEntry){
//           journalEntityMap.put(myEntry.getId(),myEntry);
//           return "Data Added Succesfully";
//    }
//    @PutMapping
//    public String updateData(@RequestBody JournalEntity myEntry){
//       journalEntityMap.replace(myEntry.getId(),myEntry);
//       return "Data updated successfullly";
//    }
//   @DeleteMapping
//    public  String deleteData(@RequestParam long id){
//       journalEntityMap.remove(id);
//       return "Data delete Successfully";
//
//   }
//
//   @GetMapping("id/{myId}")
//   public String getbyId(@PathVariable long myId){
//       return journalEntityMap.get(myId).toString();
//   }

}
