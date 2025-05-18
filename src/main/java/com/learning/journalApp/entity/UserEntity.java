package com.learning.journalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class UserEntity {
    @Id
    private  String id;
    @Indexed(unique = true)
    @NonNull
    private String name;
    @NonNull
    private String password;

    @DBRef // Refrence create in user collection of journal entries
    // Parent child relation implemented
    private List<JournalEntity> journalEntities = new ArrayList<>();

}
