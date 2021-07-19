package com.rolandsalloum.todoservice.services.todoService;


import com.rolandsalloum.todoservice.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService{

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List findAllTodos() {
        return todoRepository.findAll();
    }
}
