package com.rolandsalloum.todoservice.controllers.TodoController;

import com.rolandsalloum.todoservice.models.Todo;
import com.rolandsalloum.todoservice.services.todoService.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {


    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public ResponseEntity<?> findAllTodos() {
        try {
            List<Todo> todoList = todoService.findAllTodos();
            return ResponseEntity.status(HttpStatus.OK).body(todoList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoApiRequest request) {
        try {
            Todo todoList = todoService.createTodo(getFrom(request));
            return ResponseEntity.status(HttpStatus.OK).body(todoList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private Todo getFrom(TodoApiRequest request) {
        return Todo.builder()
                .breakTasks(request.getBreakTasks())
                .otherTasks(request.getOtherTasks())
                .date(request.getDate())
                .personalWorkingTasks(request.getPersonalWorkingTasks())
                .readingTasks(request.getReadingTasks())
                .unexpectedTasks(request.getUnexpectedTasks())
                .universityTasks(request.getUniversityTasks())
                .workingTasks(request.getWorkingTasks())
                .build();
    }
}
