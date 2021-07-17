package com.rolandsalloum.personaldashboardbackend.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Todo {

    @Id
    private UUID uuid;
    private String type;
    private String dayTime;
    private String assignedFrom;
    private String assignedTill;

}
