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
public class ReadingTaskApiRequest extends TaskApiRequest{
    private String bookTitle;
    private String type;
    private String level;

}
