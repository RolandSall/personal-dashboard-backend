package com.rolandsalloum.todoservice.models.tasks;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class WorkingTask extends Task{
    private String type;
    private String level;
    private String importance;

}
