package com.rolandsalloum.todoservice.repositories;

import com.rolandsalloum.todoservice.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.util.List;
import java.util.UUID;


public interface TodoRepository extends MongoRepository<Todo, UUID> {



    Todo findByDate(Long date);

    @Query("{'date' : { $gte: ?0, $lte: ?1 } }")
    List<Todo> findAllByDateTimeBetween(Long startDate, Long endDate);


}
