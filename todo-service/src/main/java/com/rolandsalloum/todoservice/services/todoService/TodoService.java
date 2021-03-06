package com.rolandsalloum.todoservice.services.todoService;


import com.rolandsalloum.todoservice.models.Todo;
import com.rolandsalloum.todoservice.models.tasks.*;
import com.rolandsalloum.todoservice.repositories.TodoRepository;
import com.rolandsalloum.todoservice.services.helperService.TimeConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService implements ITodoService{

    private TodoRepository todoRepository;
    private TimeConverterService timeConverterService;


    @Autowired
    public TodoService(TodoRepository todoRepository, TimeConverterService timeConverterService) {
        this.todoRepository = todoRepository;
        this.timeConverterService = timeConverterService;
    }

    @Override
    public List findAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getSingleTodoForSpecifiedDate(String startDate) throws ParseException {
        Long dateInLongFormat = timeConverterService.convertStringToLongDate(startDate);
        Todo specifiedTodo = todoRepository.findByDate(dateInLongFormat);
        return specifiedTodo;
    }

    @Override
    public List<Todo> getTodoForSpecifiedRangeDates(String startDate, String endDate) throws ParseException {
        Long startingDateInLongFormat = timeConverterService.convertStringToLongDate(startDate);
        Long endingDateInLongFormat = timeConverterService.convertStringToLongDate(endDate);
        List<Todo> todoOfSpecifiedRangeOfDates = todoRepository.findAllByDateTimeBetween(startingDateInLongFormat, endingDateInLongFormat);
        return todoOfSpecifiedRangeOfDates;
    }

    @Override
    public UUID deleteDayTodoById(UUID todoId) {
        todoRepository.deleteById(todoId);
        return todoId;
    }


    @Override
    public Todo createTodo(Todo todo) {
        UUID uuid = UUID.randomUUID();
        todo.setId(uuid);
        Todo savedToDo = todoRepository.save(todo);
        return savedToDo;
    }

    @Override
    public void updatingWorkingTaskById(Task task, String todoDate) throws ParseException {
        Long dateInLongFormat = timeConverterService.convertStringToLongDate(todoDate);
        Todo specifiedTodo = todoRepository.findByDate(dateInLongFormat);
        addNewTaskInCorrectSection(task, specifiedTodo);

    }

    @Override
    public void addTaskOnExistingTodo(Task task, String todoDate) throws ParseException {
        Long dateInLongFormat = timeConverterService.convertStringToLongDate(todoDate);
        UUID uuid = UUID.randomUUID();
        task.setId(uuid);
        Todo specifiedTodo = todoRepository.findByDate(dateInLongFormat);
        addNewTaskInCorrectSection(task, specifiedTodo);
    }

    @Override
    public UUID deleteTask(UUID id, String type, String todoDate) throws ParseException {
        Long dateInLongFormat = timeConverterService.convertStringToLongDate(todoDate);
        Todo specifiedTodo = todoRepository.findByDate(dateInLongFormat);


        switch (type){
            case "WorkingTask":
                List<WorkingTask> workingTasks = specifiedTodo.getWorkingTasks();
                workingTasks.removeIf(workingTask -> workingTask.getId().equals(id));
                specifiedTodo.setWorkingTasks(workingTasks);
                break;
            case "BreakTask":
                List<BreakTask> breakTasks = specifiedTodo.getBreakTasks();
                breakTasks.removeIf(breakTask -> breakTask.getId().equals(id));
                specifiedTodo.setBreakTasks(breakTasks);
                break;
            case "PersonalBreakingTask":
                List<PersonalWorkingTask> personalWorkingTasks = specifiedTodo.getPersonalWorkingTasks();
                personalWorkingTasks.removeIf(personalWorkingTask -> personalWorkingTask.getId().equals(id));
                specifiedTodo.setPersonalWorkingTasks(personalWorkingTasks);
                break;
            case "ReadingTask":
                List<ReadingTask> readingTasks = specifiedTodo.getReadingTasks();
                readingTasks.removeIf(readingTask -> readingTask.getId().equals(id));
                specifiedTodo.setReadingTasks(readingTasks);
                break;
            case "UnexpectedTask":
                List<UnexpectedTask> unexpectedTasks = specifiedTodo.getUnexpectedTasks();
                unexpectedTasks.removeIf(unexpectedTask -> unexpectedTask.getId().equals(id));
                specifiedTodo.setUnexpectedTasks(unexpectedTasks);
                break;
            case "UniversityTask":
                List<UniversityTask> universityTasks = specifiedTodo.getUniversityTasks();
                universityTasks.removeIf(universityTask -> universityTask.getId().equals(id));
                specifiedTodo.setUniversityTasks(universityTasks);
                break;
            default:
                return id;
        }

        todoRepository.save(specifiedTodo);
        return id;
    }


    //TODO: think of a better way to do below
    private void addNewTaskInCorrectSection(Task task, Todo specifiedTodo) {
        if (task instanceof WorkingTask) {
            List<WorkingTask> workingTasks = specifiedTodo.getWorkingTasks();
            workingTasks.add((WorkingTask) task);
            specifiedTodo.setWorkingTasks(workingTasks);
            todoRepository.save(specifiedTodo);
        }else if(task instanceof UniversityTask){
            List<UniversityTask> universityTasks = specifiedTodo.getUniversityTasks();
            universityTasks.add((UniversityTask) task);
            specifiedTodo.setUniversityTasks(universityTasks);
            todoRepository.save(specifiedTodo);
        }else if(task instanceof UnexpectedTask){
            List<UnexpectedTask> unexpectedTasks = specifiedTodo.getUnexpectedTasks();
            unexpectedTasks.add((UnexpectedTask) task);
            specifiedTodo.setUnexpectedTasks(unexpectedTasks);
            todoRepository.save(specifiedTodo);
        }else if(task instanceof ReadingTask){
            List<ReadingTask> readingTasks = specifiedTodo.getReadingTasks();
            readingTasks.add((ReadingTask) task);
            specifiedTodo.setReadingTasks(readingTasks);
            todoRepository.save(specifiedTodo);
        }else if(task instanceof PersonalWorkingTask){
            List<PersonalWorkingTask> personalWorkingTasks = specifiedTodo.getPersonalWorkingTasks();
            personalWorkingTasks.add((PersonalWorkingTask) task);
            specifiedTodo.setPersonalWorkingTasks(personalWorkingTasks);
            todoRepository.save(specifiedTodo);
        }else if(task instanceof OtherTask){
            List<OtherTask> otherTasks = specifiedTodo.getOtherTasks();
            otherTasks.add((OtherTask) task);
            specifiedTodo.setOtherTasks(otherTasks);
            todoRepository.save(specifiedTodo);
        }else if(task instanceof BreakTask){
            List<BreakTask> breakTasks = specifiedTodo.getBreakTasks();
            breakTasks.add((BreakTask) task);
            specifiedTodo.setBreakTasks(breakTasks);
            todoRepository.save(specifiedTodo);
        }else{
            // do nothing
        }
    }


}
