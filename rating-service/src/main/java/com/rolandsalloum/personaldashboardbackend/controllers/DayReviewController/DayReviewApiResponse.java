package com.rolandsalloum.personaldashboardbackend.controllers.DayReviewController;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DayReviewApiResponse {
    private Date date;
    private String formattedDate;
    private String note;
    private boolean WakeUpEarly;
    private boolean training;
    private boolean morningHabit;
    private boolean reading;
}
