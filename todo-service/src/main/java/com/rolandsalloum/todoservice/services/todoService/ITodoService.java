package com.rolandsalloum.todoservice.services.todoService;

import com.rolandsalloum.todoservice.models.Todo;

import java.util.List;

public interface ITodoService {
    List<Todo> findAllTodos();
}
