package com.rolandsalloum.personaldashboardbackend.services;

import com.rolandsalloum.personaldashboardbackend.models.DayReview;

public interface IDayReviewService {
    DayReview getDayReviewById(String dayId);
}
