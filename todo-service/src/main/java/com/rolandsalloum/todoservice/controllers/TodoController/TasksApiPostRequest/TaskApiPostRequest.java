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
public class TaskApiPostRequest {
    private String assignedFrom;
    private String assignedTill;
    private String title;
    private String description;
    private String actualTimeSpent;

}
