package com.rolandsalloum.personaldashboardbackend.services.DayReviewService;

import com.rolandsalloum.personaldashboardbackend.controllers.DayReviewController.DayReviewRange;
import com.rolandsalloum.personaldashboardbackend.models.DayReview;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IDayReviewService {
    DayReview getDayReviewById(String dayId) throws ParseException;


    List<DayReview> getAllDayReviews();

    List<DayReview> getRangeOfAllDaysReview(String start, String end) throws ParseException;
}
