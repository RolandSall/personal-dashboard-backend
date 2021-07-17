package com.rolandsalloum.personaldashboardbackend.services;

import com.rolandsalloum.personaldashboardbackend.models.DayReview;
import com.rolandsalloum.personaldashboardbackend.repositories.DayReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
