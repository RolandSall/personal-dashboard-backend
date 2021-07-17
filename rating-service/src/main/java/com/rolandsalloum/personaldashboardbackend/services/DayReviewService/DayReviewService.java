package com.rolandsalloum.personaldashboardbackend.services.DayReviewService;

import com.rolandsalloum.personaldashboardbackend.controllers.DayReviewController.DayReviewRange;
import com.rolandsalloum.personaldashboardbackend.models.DayReview;
import com.rolandsalloum.personaldashboardbackend.repositories.DayReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DayReviewService implements IDayReviewService{

    private final DayReviewDTO  dayReviewDTO;
    private SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public DayReviewService(DayReviewDTO dayReviewDTO) {
        this.dayReviewDTO = dayReviewDTO;
    }

    @Override
    public DayReview getDayReviewById(String dayId) throws ParseException {
        Date date = DateFor.parse(dayId);
        return dayReviewDTO.getById(date);
    }

    @Override
    public List<DayReview> getAllDayReviews() {
        return dayReviewDTO.findAll();
    }

    @Override
    public List<DayReview> getRangeOfAllDaysReview(String start, String end) throws ParseException {
        Date startDayDate = DateFor.parse(start);
        Date endDayDate= DateFor.parse(end);
        return dayReviewDTO.getDayReviewInRange(startDayDate, endDayDate);
    }


}
