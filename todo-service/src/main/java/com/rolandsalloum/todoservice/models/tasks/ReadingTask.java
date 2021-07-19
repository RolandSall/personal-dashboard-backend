package com.rolandsalloum.todoservice.models.tasks;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadingTask extends Task{
    private String bookTitle;
    private String type;
    private String level;

}
