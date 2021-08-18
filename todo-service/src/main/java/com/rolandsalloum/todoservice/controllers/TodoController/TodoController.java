package com.rolandsalloum.todoservice.controllers.TodoController;

import com.rolandsalloum.todoservice.controllers.TodoController.TasksApiPostRequest.*;
import com.rolandsalloum.todoservice.controllers.TodoController.TasksApiPutRequest.*;
import com.rolandsalloum.todoservice.models.Todo;
import com.rolandsalloum.todoservice.models.tasks.*;
import com.rolandsalloum.todoservice.services.helperService.ITimeConverterService;
import com.rolandsalloum.todoservice.services.todoService.TodoService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todos")
public class TodoController {


    private TodoService todoService;
    private ITimeConverterService timeConverterService;


    @Autowired
    public TodoController(TodoService todoService, ITimeConverterService timeConverterService) {
        this.todoService = todoService;
        this.timeConverterService = timeConverterService;
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

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteDayTodoById(@PathVariable UUID todoId) {
        try {
            UUID todoList = todoService.deleteDayTodoById(todoId);
            return ResponseEntity.status(HttpStatus.OK).body(todoList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/start/{startDate}/end/{endDate}")
    public ResponseEntity<?> getTodoForSpecifiedDates(@PathVariable String endDate, @PathVariable String startDate) {
        try {
            if(endDate.equals(startDate)) {
                Todo todo = todoService.getSingleTodoForSpecifiedDate(startDate);
                return ResponseEntity.status(HttpStatus.OK).body(todo);
            }else {
                List<Todo> listOfTodos = todoService.getTodoForSpecifiedRangeDates(startDate,endDate);
                return ResponseEntity.status(HttpStatus.OK).body(listOfTodos);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



    @DeleteMapping("/{todoDate}/tasks/{type}/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable UUID id, @PathVariable String type, @PathVariable String todoDate) {
        try {
            UUID taskIdRemoved = todoService.deleteTask(id, type, todoDate);
            return ResponseEntity.status(HttpStatus.OK).body(taskIdRemoved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoApiRequest request) {
        try {
            Todo todo = todoService.createTodo(getFrom(request));
            return ResponseEntity.status(HttpStatus.OK).body(timeConverterService.convertLongToActualDate(todo.getDate()).toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/{todoDate}/tasks/working-task")
    public ResponseEntity<?> addWorkingTaskOnExistingTodo(@RequestBody WorkingTaskApiPostRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true) @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromWorkingTaskPostRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{todoDate}/tasks/working-task/{working-task-id}")
    public ResponseEntity<?> updatingWorkingTaskById(@RequestBody WorkingTaskApiPutRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate,
                                                     @PathVariable("working-task-id") UUID workingTaskId) {
        try {
            todoService.updatingWorkingTaskById(getFromWorkingTaskPutRequest(request, workingTaskId), todoDate);
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



    @PostMapping("/{todoDate}/tasks/unexpected-task")
    public ResponseEntity<?> addUnexpectedTaskOnExistingTodo(@RequestBody UnexpectedTaskApiPostRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromUnexpectedTaskPostRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{todoDate}/tasks/unexpected-task/{unexpected-task}")
    public ResponseEntity<?> updatingUnexpectedTaskById(@RequestBody UnexpectedTaskApiPutRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate,
                                                     @PathVariable("unexpected-task") UUID unexpectedTaskId) {
        try {
            todoService.updatingWorkingTaskById(getFromUnexpectedTaskPutRequest(request, unexpectedTaskId), todoDate);
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @PostMapping("/{todoDate}/tasks/university-task")
    public ResponseEntity<?> addUniversityTaskOnExistingTodo(@RequestBody UniversityTaskApiPostRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromUniversityTaskPostRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{todoDate}/tasks/university-task/{university-task}")
    public ResponseEntity<?> updatingUniversityTaskById(@RequestBody UniversityTaskApiPutRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate,
                                                        @PathVariable("university-task") UUID universityTaskId) {
        try {
            todoService.updatingWorkingTaskById(getFromUniversityTaskPutRequest(request, universityTaskId),  todoDate);
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @PostMapping("/{todoDate}/tasks/reading-task")
    public ResponseEntity<?> addReadingTaskOnExistingTodo(@RequestBody ReadingTaskApiPostRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromReadingTaskPostRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{todoDate}/tasks/reading-task/{reading-task}")
    public ResponseEntity<?> updatingReadingTaskById(@RequestBody ReadingTaskApiPutRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate,
                                                        @PathVariable("reading-task") UUID universityTaskId) {
        try {
            todoService.updatingWorkingTaskById(getFromReadingTaskPutRequest(request, universityTaskId), todoDate);
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/{todoDate}/tasks/personal-working-task")
    public ResponseEntity<?> addPersonalWorkingTaskOnExistingTodo(@RequestBody PersonalWorkingTaskApiPostRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromPersonalWorkingTaskPostRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{todoDate}/tasks/personal-working-task/{personal-working-task}")
    public ResponseEntity<?> updatingReadingTaskById(@RequestBody PersonalWorkingTaskApiPutRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate,
                                                     @PathVariable("personal-working-task") UUID personalWorkingTaskId) {
        try {
            todoService.updatingWorkingTaskById(getFromPersonalWorkingTaskPutRequest(request, personalWorkingTaskId), todoDate);
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/{todoDate}/tasks/other-task")
    public ResponseEntity<?> addOtherTaskOnExistingTodo(@RequestBody OtherTaskApiPostRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromOtherTaskPostRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{todoDate}/tasks/other-task/{other-task}")
    public ResponseEntity<?> updatingOtherTaskById(@RequestBody OtherTaskApiPutRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate,
                                                     @PathVariable("other-task") UUID otherTaskId) {
        try {
            todoService.updatingWorkingTaskById(getFromOtherTaskPutRequest(request, otherTaskId), todoDate);
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/{todoDate}/tasks/break-task")
    public ResponseEntity<?> addBreakTaskOnExistingTodo(@RequestBody BreakTaskApiPostRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)  @PathVariable String todoDate) {
        try {
            todoService.addTaskOnExistingTodo(getFromBreakTaskPostRequest(request), todoDate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{todoDate}/tasks/break-task/{break-task}")
    public ResponseEntity<?> updatingBreakTaskById(@RequestBody BreakTaskApiPutRequest request, @ApiParam(value = "Date Format: YYYY-MM-DD", required = true)   @PathVariable String todoDate,
                                                   @PathVariable("break-task") UUID breakTaskId) {
        try {
            todoService.updatingWorkingTaskById(getFromBreakTaskPutRequest(request, breakTaskId), todoDate);
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



    private BreakTask getFromBreakTaskPostRequest(BreakTaskApiPostRequest request) {
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
    private BreakTask getFromBreakTaskPutRequest(BreakTaskApiPutRequest request, UUID breakTaskId) {
        return BreakTask.builder()
                .id(breakTaskId)
                .done(request.isDone())
                .assignedFrom(request.getAssignedFrom())
                .assignedTill(request.getAssignedTill())
                .title(request.getTitle())
                .actualTimeSpent(request.getActualTimeSpent())
                .description(request.getDescription())
                .type(request.getType())
                .build();
    }

    private OtherTask getFromOtherTaskPostRequest(OtherTaskApiPostRequest request) {
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
    private OtherTask getFromOtherTaskPutRequest(OtherTaskApiPutRequest request, UUID otherTaskId) {
        return OtherTask.builder()
                .id(otherTaskId)
                .done(request.isDone())
                .assignedFrom(request.getAssignedFrom())
                .assignedTill(request.getAssignedTill())
                .title(request.getTitle())
                .actualTimeSpent(request.getActualTimeSpent())
                .description(request.getDescription())
                .type(request.getType())
                .build();
    }

    private PersonalWorkingTask getFromPersonalWorkingTaskPostRequest(PersonalWorkingTaskApiPostRequest request) {
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
    private PersonalWorkingTask getFromPersonalWorkingTaskPutRequest(PersonalWorkingTaskApiPutRequest request, UUID personalWorkingTaskId) {
        return PersonalWorkingTask.builder()
                .id(personalWorkingTaskId)
                .done(request.isDone())
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


    private ReadingTask getFromReadingTaskPostRequest(ReadingTaskApiPostRequest request) {
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
    private ReadingTask getFromReadingTaskPutRequest(ReadingTaskApiPutRequest request, UUID readingTaskId) {
        return ReadingTask.builder()
                .id(readingTaskId)
                .done(request.isDone())
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

    private UnexpectedTask getFromUnexpectedTaskPostRequest(UnexpectedTaskApiPostRequest request) {
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
    private UnexpectedTask getFromUnexpectedTaskPutRequest(UnexpectedTaskApiPutRequest request, UUID unexpectedTaskId) {
        return UnexpectedTask.builder()
                .id(unexpectedTaskId)
                .done(request.isDone())
                .assignedFrom(request.getAssignedFrom())
                .assignedTill(request.getAssignedTill())
                .title(request.getTitle())
                .actualTimeSpent(request.getActualTimeSpent())
                .description(request.getDescription())
                .reason(request.getReason())
                .importanceLevel(request.getImportanceLevel())
                .build();
    }


    private WorkingTask getFromWorkingTaskPostRequest(WorkingTaskApiPostRequest request) {
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
    private WorkingTask getFromWorkingTaskPutRequest(WorkingTaskApiPutRequest request, UUID workingTaskId) {
        return WorkingTask.builder()
                .id(workingTaskId)
                .done(request.isDone())
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


    private UniversityTask getFromUniversityTaskPostRequest(UniversityTaskApiPostRequest request) {
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
    private UniversityTask getFromUniversityTaskPutRequest(UniversityTaskApiPutRequest request, UUID universityTaskId) {
        return UniversityTask.builder()
                .id(universityTaskId)
                .done(request.isDone())
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

    private Todo getFrom(TodoApiRequest request) throws ParseException {
        return Todo.builder()
                .breakTasks(Collections.emptyList())
                .otherTasks(Collections.emptyList())
                .date(timeConverterService.convertStringToLongDate(request.getDate()))
                .personalWorkingTasks(Collections.emptyList())
                .readingTasks(Collections.emptyList())
                .unexpectedTasks(Collections.emptyList())
                .universityTasks(Collections.emptyList())
                .workingTasks(Collections.emptyList())
                .build();
    }
}
