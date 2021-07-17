package com.rolandsalloum.personaldashboardbackend.services.GenerateDaysService;

import com.rolandsalloum.personaldashboardbackend.controllers.GenerateDaysController.DayObject;

import java.text.ParseException;

public interface IGenerateDaysService {

    void generateWeek(DayObject day) throws ParseException;
}
