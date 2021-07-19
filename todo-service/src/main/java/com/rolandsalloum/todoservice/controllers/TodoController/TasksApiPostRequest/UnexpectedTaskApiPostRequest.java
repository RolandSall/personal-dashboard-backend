package com.rolandsalloum.todoservice.controllers.TodoController.TasksApiPostRequest;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UnexpectedTaskApiPostRequest extends TaskApiPostRequest {
    private String reason;
    private String importanceLevel;
}
