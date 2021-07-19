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
public class UnexpectedTaskApiPutRequest extends TaskApiPutRequest {
    private String reason;
    private String importanceLevel;
}
