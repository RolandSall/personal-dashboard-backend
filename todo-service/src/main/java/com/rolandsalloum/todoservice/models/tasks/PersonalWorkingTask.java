package com.rolandsalloum.todoservice.models.tasks;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PersonalWorkingTask extends Task{
    private String topic;
    private String level;
    private String typeOfLearning;
}
