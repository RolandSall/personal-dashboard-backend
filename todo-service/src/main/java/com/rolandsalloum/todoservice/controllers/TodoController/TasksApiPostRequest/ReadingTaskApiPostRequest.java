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
public class ReadingTaskApiPostRequest extends TaskApiPostRequest {
    private String bookTitle;
    private String type;
    private String level;

}
