package com.rolandsalloum.personaldashboardbackend.services.DayReviewService;

import com.rolandsalloum.personaldashboardbackend.controllers.DayReviewController.DayReviewRange;
import com.rolandsalloum.personaldashboardbackend.models.DayReview;
import com.rolandsalloum.personaldashboardbackend.repositories.DayReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayReviewService implements IDayReviewService{

    private final DayReviewDTO  dayReviewDTO;

    @Autowired
    public DayReviewService(DayReviewDTO dayReviewDTO) {
        this.dayReviewDTO = dayReviewDTO;
    }

    @Override
    public DayReview getDayReviewById(String dayId) {
        return dayReviewDTO.getById(dayId);
    }

    @Override
    public List<DayReview> getAllDayReviews() {
        return dayReviewDTO.findAll();
    }

    @Override
    public List<DayReview> getRangeOfAllDaysReview(DayReviewRange dayReviewRange) {
        return  null;
    }


}
