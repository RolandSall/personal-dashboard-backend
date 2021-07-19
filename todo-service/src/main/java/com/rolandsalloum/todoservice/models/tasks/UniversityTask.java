package com.rolandsalloum.todoservice.models.tasks;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UniversityTask extends Task{
    private String courseName;
    private String courseType;
    private String level;

}
