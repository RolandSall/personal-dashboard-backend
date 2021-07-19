package com.rolandsalloum.todoservice.services.todoService;


import com.rolandsalloum.todoservice.models.Todo;
import com.rolandsalloum.todoservice.models.tasks.Task;
import com.rolandsalloum.todoservice.models.tasks.WorkingTask;
import com.rolandsalloum.todoservice.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    @Override
    public Todo createTodo(Todo todo) {
        UUID uuid = UUID.randomUUID();
        todo.setId(uuid);
        return todoRepository.save(todo);
    }

    @Override
    public void addTaskOnExistingTodo(Task task, String todoDate) {
        Todo specifiedTodo = todoRepository.findByDate(todoDate);
        if (task instanceof WorkingTask) {
            List<WorkingTask> workingTasks = specifiedTodo.getWorkingTasks();
            workingTasks.add((WorkingTask) task);
            specifiedTodo.setWorkingTasks(workingTasks);
            todoRepository.save(specifiedTodo);
        }
    }


}
