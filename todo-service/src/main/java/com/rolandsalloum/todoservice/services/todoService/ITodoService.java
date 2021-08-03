package com.rolandsalloum.todoservice.services.todoService;

import com.rolandsalloum.todoservice.models.Todo;
import com.rolandsalloum.todoservice.models.tasks.Task;
import com.rolandsalloum.todoservice.models.tasks.WorkingTask;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

public interface ITodoService {
    List<Todo> findAllTodos();

    Todo createTodo(Todo todo);

    void addTaskOnExistingTodo(Task task, String todoDate);

    UUID deleteTask(UUID id, String type, String todoDate);


    void updatingWorkingTaskById(Task task, String todoDate);


    Todo getSingleTodoForSpecifiedDate(String startDate) throws ParseException;

    List<Todo> getTodoForSpecifiedRangeDates(String startDate, String endDate) throws ParseException;
}
