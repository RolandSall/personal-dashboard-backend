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
public class WorkingTaskApiRequest extends TaskApiRequest{
    private String type;
    private String level;
    private String importance;

}
