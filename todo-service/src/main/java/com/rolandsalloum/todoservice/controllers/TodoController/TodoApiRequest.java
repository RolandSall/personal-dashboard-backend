package com.rolandsalloum.todoservice.controllers.TodoController;

import com.rolandsalloum.todoservice.models.tasks.*;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
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

    @ApiModelProperty(required = true, example = "YYYY-MM-DD")
    private String date;



}
