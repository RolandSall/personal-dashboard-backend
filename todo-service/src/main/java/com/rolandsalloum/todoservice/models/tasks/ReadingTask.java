package com.rolandsalloum.todoservice.models.tasks;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ReadingTask extends Task{
    private String bookTitle;
    private String type;
    private String level;

}
