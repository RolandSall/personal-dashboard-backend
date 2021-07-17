package com.rolandsalloum.personaldashboardbackend.services.DayReviewService;

import com.rolandsalloum.personaldashboardbackend.controllers.DayReviewController.DayReviewRange;
import com.rolandsalloum.personaldashboardbackend.models.DayReview;

import java.util.List;

public interface IDayReviewService {
    DayReview getDayReviewById(String dayId);


    List<DayReview> getAllDayReviews();

    List<DayReview> getRangeOfAllDaysReview(DayReviewRange dayReviewRange);
}
