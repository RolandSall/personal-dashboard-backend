package com.rolandsalloum.personaldashboardbackend.controllers.DayReviewController;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class DayReviewRange {
    private String startingDate;
    private String endDate;
}
