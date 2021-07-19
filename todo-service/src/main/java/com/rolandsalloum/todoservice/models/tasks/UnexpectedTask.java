package com.rolandsalloum.todoservice.models.tasks;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UnexpectedTask extends Task{
    private String reason;
    private String importanceLevel;

}
