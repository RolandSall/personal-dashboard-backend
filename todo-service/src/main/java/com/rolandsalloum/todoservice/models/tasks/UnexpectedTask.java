package com.rolandsalloum.todoservice.models.tasks;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnexpectedTask extends Task{
    private String reason;
    private String importanceLevel;

}
