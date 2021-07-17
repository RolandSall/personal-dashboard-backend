package com.rolandsalloum.personaldashboardbackend.controllers;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DayReviewApiResponse {
    private String date;
    private String note;
    private boolean WakeUpEarly;
    private boolean training;
    private boolean morningHabit;
    private boolean reading;
}
