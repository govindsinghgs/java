package com.learning.journalApp.service;

import com.learning.journalApp.entity.JournalEntity;
import com.learning.journalApp.entity.UserEntity;
import com.learning.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    public void  saveEntry(JournalEntity journalEntity, String username){
        UserEntity user = userService.findByUsername(username);
        JournalEntity saved = journalEntryRepository.save(journalEntity);
        user.getJournalEntities().add(saved);
        userService.saveEntry(user);

    }

    public void deleteEntry(String id, String username) {
        UserEntity  user = userService.findByUsername(username);
        user.getJournalEntities().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }

    public List<JournalEntity> getDetails() {
      return   journalEntryRepository.findAll();
    }

    public void updateDetails(JournalEntity journalEntity) {
        journalEntryRepository.save(journalEntity);
    }
}
