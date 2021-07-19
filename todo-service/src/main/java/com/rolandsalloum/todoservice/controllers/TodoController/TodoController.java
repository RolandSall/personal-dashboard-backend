package com.rolandsalloum.todoservice.controllers.TodoController;

import com.rolandsalloum.todoservice.controllers.TodoController.TasksApiRequest.*;
import com.rolandsalloum.todoservice.models.Todo;
import com.rolandsalloum.todoservice.models.tasks.*;
import com.rolandsalloum.todoservice.services.todoService.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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


    @DeleteMapping("/{todoDate}/tasks/{type}/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable UUID id, @PathVariable String type, @PathVariable String todoDate) {
        try {
            UUID taskIdRemoved = todoService.deleteTask(id,type,todoDate);
            return ResponseEntity.status(HttpStatus.OK).body(taskIdRemoved);
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

    @PostMapping("/{todoDate}/tasks/working-task")
    public ResponseEntity<?> addWorkingTaskOnExistingTodo(@RequestBody WorkingTaskApiRequest request, @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromWorkingTaskRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/{todoDate}/tasks/unexpected-task")
    public ResponseEntity<?> addUnexpectedTaskOnExistingTodo(@RequestBody UnexpectedTaskApiRequest request, @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromUnexpectedTaskRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/{todoDate}/tasks/university-task")
    public ResponseEntity<?> addUniversityTaskOnExistingTodo(@RequestBody UniversityTaskApiRequest request, @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromUniversityTaskRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/{todoDate}/tasks/reading-task")
    public ResponseEntity<?> addReadingTaskOnExistingTodo(@RequestBody ReadingTaskApiRequest request, @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromReadingTaskRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/{todoDate}/tasks/personal-working-task")
    public ResponseEntity<?> addPersonalWorkingTaskOnExistingTodo(@RequestBody PersonalWorkingTaskApiRequest request, @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromPersonalWorkingTaskRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/{todoDate}/tasks/other-task")
    public ResponseEntity<?> addOtherTaskOnExistingTodo(@RequestBody OtherTaskApiRequest request, @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromOtherTaskRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/{todoDate}/tasks/break-task")
    public ResponseEntity<?> addBreakTaskOnExistingTodo(@RequestBody BreakTaskApiRequest request, @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromBreakTaskRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private BreakTask getFromBreakTaskRequest(BreakTaskApiRequest request) {
        return BreakTask.builder()
                .done(false)
                .assignedFrom(request.getAssignedFrom())
                .assignedTill(request.getAssignedTill())
                .title(request.getTitle())
                .actualTimeSpent(request.getActualTimeSpent())
                .description(request.getDescription())
                .type(request.getType())
                .build();
    }


    private OtherTask getFromOtherTaskRequest(OtherTaskApiRequest request) {
        return OtherTask.builder()
                .done(false)
                .assignedFrom(request.getAssignedFrom())
                .assignedTill(request.getAssignedTill())
                .title(request.getTitle())
                .actualTimeSpent(request.getActualTimeSpent())
                .description(request.getDescription())
                .type(request.getType())
                .build();
    }

    private PersonalWorkingTask getFromPersonalWorkingTaskRequest(PersonalWorkingTaskApiRequest request) {
        return PersonalWorkingTask.builder()
                .done(false)
                .assignedFrom(request.getAssignedFrom())
                .assignedTill(request.getAssignedTill())
                .title(request.getTitle())
                .actualTimeSpent(request.getActualTimeSpent())
                .description(request.getDescription())
                .typeOfLearning(request.getTypeOfLearning())
                .topic(request.getTopic())
                .level(request.getLevel())
                .build();
    }


    private ReadingTask getFromReadingTaskRequest(ReadingTaskApiRequest request) {
        return ReadingTask.builder()
                .done(false)
                .assignedFrom(request.getAssignedFrom())
                .assignedTill(request.getAssignedTill())
                .title(request.getTitle())
                .actualTimeSpent(request.getActualTimeSpent())
                .description(request.getDescription())
                .bookTitle(request.getBookTitle())
                .type(request.getType())
                .level(request.getLevel())
                .build();
    }

    private UnexpectedTask getFromUnexpectedTaskRequest(UnexpectedTaskApiRequest request) {
        return UnexpectedTask.builder()
                .done(false)
                .assignedFrom(request.getAssignedFrom())
                .assignedTill(request.getAssignedTill())
                .title(request.getTitle())
                .actualTimeSpent(request.getActualTimeSpent())
                .description(request.getDescription())
                .reason(request.getReason())
                .importanceLevel(request.getImportanceLevel())
                .build();
    }


    private WorkingTask getFromWorkingTaskRequest(WorkingTaskApiRequest request) {
        return WorkingTask.builder()
                .done(false)
                .assignedFrom(request.getAssignedFrom())
                .assignedTill(request.getAssignedTill())
                .title(request.getTitle())
                .actualTimeSpent(request.getActualTimeSpent())
                .description(request.getDescription())
                .level(request.getLevel())
                .type(request.getType())
                .importance(request.getImportance())
                .build();
    }

    private UniversityTask getFromUniversityTaskRequest(UniversityTaskApiRequest request) {
        return UniversityTask.builder()
                .done(false)
                .assignedFrom(request.getAssignedFrom())
                .assignedTill(request.getAssignedTill())
                .title(request.getTitle())
                .actualTimeSpent(request.getActualTimeSpent())
                .description(request.getDescription())
                .level(request.getLevel())
                .courseName(request.getCourseName())
                .courseType(request.getCourseType())
                .build();
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
