package com.rolandsalloum.todoservice.services.todoService;

import com.rolandsalloum.todoservice.models.Todo;
import com.rolandsalloum.todoservice.models.tasks.Task;

import java.util.List;

public interface ITodoService {
    List<Todo> findAllTodos();

    Todo createTodo(Todo todo);

    void addTaskOnExistingTodo(Task task, String todoDate);
}
