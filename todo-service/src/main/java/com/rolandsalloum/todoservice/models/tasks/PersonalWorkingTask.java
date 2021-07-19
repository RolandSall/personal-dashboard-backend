package com.rolandsalloum.todoservice.models.tasks;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalWorkingTask extends Task{
    private String topic;
    private String level;
    private String typeOfLearning;
}
