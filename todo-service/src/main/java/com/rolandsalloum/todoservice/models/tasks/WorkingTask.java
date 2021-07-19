package com.rolandsalloum.todoservice.models.tasks;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkingTask extends Task{
    private String type;
    private String level;
    private String importance;

}
