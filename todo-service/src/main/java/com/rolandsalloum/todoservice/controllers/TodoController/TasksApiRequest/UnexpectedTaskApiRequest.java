package com.rolandsalloum.todoservice.controllers.TodoController.TasksApiRequest;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UnexpectedTaskApiRequest extends  TaskApiRequest{
    private String reason;
    private String importanceLevel;
}
