package com.rolandsalloum.personaldashboardbackend.controllers;

import com.rolandsalloum.personaldashboardbackend.models.DayReview;
import com.rolandsalloum.personaldashboardbackend.services.DayReviewService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/days")
public class DayReviewController {


    private DayReviewService dayReviewService;

    @Autowired
    public DayReviewController(DayReviewService dayReviewService) {
        this.dayReviewService = dayReviewService;
    }

    @GetMapping("/{dayId}")
    public ResponseEntity<?> getDayReviewById(@PathVariable String dayId) {
        try {
            DayReview dayReview = dayReviewService.getDayReviewById(dayId);
            DayReviewApiResponse response = buildDayReviewSingleApiResponseFrom(dayReview);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private DayReviewApiResponse buildDayReviewSingleApiResponseFrom(DayReview dayReview) {
        return DayReviewApiResponse.builder()
                .date(dayReview.getDate())
                .morningHabit(dayReview.isMorningHabit())
                .note(dayReview.getNote())
                .reading(dayReview.isReading())
                .training(dayReview.isTraining())
                .WakeUpEarly(dayReview.isWakeUpEarly())
                .build();
    }
}
