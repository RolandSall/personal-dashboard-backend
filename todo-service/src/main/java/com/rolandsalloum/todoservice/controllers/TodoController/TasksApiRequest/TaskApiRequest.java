package com.rolandsalloum.todoservice.controllers.TodoController.TasksApiRequest;

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
public class TaskApiRequest {
    private String assignedFrom;
    private String assignedTill;
    private String title;
    private String description;
    private String actualTimeSpent;
}
