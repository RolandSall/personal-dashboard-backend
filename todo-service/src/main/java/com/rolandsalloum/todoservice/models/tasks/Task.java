package com.rolandsalloum.todoservice.models.tasks;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    private String assignedFrom;
    private String assignedTill;
    private String title;
    private String description;
    private String actualTimeSpent;
}
