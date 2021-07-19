package com.rolandsalloum.todoservice.controllers.TodoController.TasksApiPutRequest;

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
public class BreakTaskApiPutRequest extends TaskApiPutRequest {
    private String type;
}
