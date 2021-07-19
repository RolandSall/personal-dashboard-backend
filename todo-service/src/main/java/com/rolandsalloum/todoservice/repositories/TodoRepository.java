package com.rolandsalloum.todoservice.repositories;

import com.rolandsalloum.todoservice.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.UUID;


public interface TodoRepository extends MongoRepository<Todo, UUID> {

    Todo findByDate(String date);
}
