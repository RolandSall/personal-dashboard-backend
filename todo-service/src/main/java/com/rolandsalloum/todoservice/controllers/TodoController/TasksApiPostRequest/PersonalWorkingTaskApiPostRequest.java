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
public class PersonalWorkingTaskApiPostRequest extends TaskApiPostRequest {
    private String topic;
    private String level;
    private String typeOfLearning;
}
