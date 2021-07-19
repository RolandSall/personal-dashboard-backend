package com.rolandsalloum.todoservice.models;

import com.rolandsalloum.todoservice.models.tasks.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "todos")
public class Todo {

    @Id
    private UUID id;
    private String date;

    private List<UniversityTask> universityTasks;
    private List<UnexpectedTask> unexpectedTasks;
    private List<WorkingTask> workingTasks;
    private List<BreakTask> breakTasks;
    private List<ReadingTask> readingTasks;
    private List<PersonalWorkingTask> personalWorkingTasks;
    private List<OtherTask> otherTasks;






}
