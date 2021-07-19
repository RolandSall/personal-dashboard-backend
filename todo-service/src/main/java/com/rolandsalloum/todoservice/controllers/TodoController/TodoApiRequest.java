package com.rolandsalloum.todoservice.controllers.TodoController;

import com.rolandsalloum.todoservice.models.tasks.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TodoApiRequest {
    private String date;

    private List<UniversityTask> universityTasks;
    private List<UnexpectedTask> unexpectedTasks;
    private List<WorkingTask> workingTasks;
    private List<BreakTask> breakTasks;
    private List<ReadingTask> readingTasks;
    private List<PersonalWorkingTask> personalWorkingTasks;
    private List<OtherTask> otherTasks;

}
