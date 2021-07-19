package com.rolandsalloum.todoservice.models.tasks;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OtherTask extends Task{
    private String type;
}
