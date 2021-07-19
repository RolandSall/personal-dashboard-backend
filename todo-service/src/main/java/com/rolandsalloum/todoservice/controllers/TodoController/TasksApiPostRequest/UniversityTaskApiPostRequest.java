package com.rolandsalloum.todoservice.controllers.TodoController.TasksApiPostRequest;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UniversityTaskApiPostRequest extends TaskApiPostRequest {
    private String courseName;
    private String courseType;
    private String level;
}
