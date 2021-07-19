package com.rolandsalloum.todoservice.models.tasks;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniversityTask extends Task{
    private String courseName;
    private String courseType;
    private String level;

}
