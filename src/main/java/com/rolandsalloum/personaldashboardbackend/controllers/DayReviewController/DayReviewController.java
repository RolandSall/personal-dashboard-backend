package com.rolandsalloum.personaldashboardbackend.controllers.DayReviewController;

import com.rolandsalloum.personaldashboardbackend.models.DayReview;
import com.rolandsalloum.personaldashboardbackend.services.DayReviewService.DayReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @GetMapping("")
    public ResponseEntity<?> getAllDayReviews() {
        try {
            List<DayReview> dayReviewList = dayReviewService.getAllDayReviews();

            return ResponseEntity.status(HttpStatus.OK).body(dayReviewList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/range/from/{start}/to/{end}")
    public ResponseEntity<?> getRangeOfAllDaysReview(@PathVariable String start, @PathVariable String end) {
        try {
            List<DayReview> dayReviewList = dayReviewService.getRangeOfAllDaysReview(start,end);
            return ResponseEntity.status(HttpStatus.OK).body(dayReviewList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private DayReviewApiResponse buildDayReviewSingleApiResponseFrom(DayReview dayReview) {
        return DayReviewApiResponse.builder()
                .date(dayReview.getDate())
                .formattedDate(dayReview.getFormattedDay())
                .morningHabit(dayReview.isMorningHabit())
                .note(dayReview.getNote())
                .reading(dayReview.isReading())
                .training(dayReview.isTraining())
                .WakeUpEarly(dayReview.isWakeUpEarly())
                .build();
    }
}
