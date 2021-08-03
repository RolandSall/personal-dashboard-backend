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



}
