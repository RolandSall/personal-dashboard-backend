package com.rolandsalloum.todoservice.models.tasks;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Task {
    @Id
    private UUID id;
    private String assignedFrom;
    private String assignedTill;
    private String title;
    private String description;
    private String actualTimeSpent;
    private boolean done;
}
