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
public class OtherTaskApiRequest extends TaskApiRequest{
    private String type;
}
