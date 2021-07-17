package com.rolandsalloum.personaldashboardbackend.services.GenerateDaysService;

import com.rolandsalloum.personaldashboardbackend.controllers.GenerateDaysController.DayObject;
import com.rolandsalloum.personaldashboardbackend.models.DayReview;
import com.rolandsalloum.personaldashboardbackend.repositories.DayReviewDTO;
import com.rolandsalloum.personaldashboardbackend.services.DayReviewService.DayReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateDaysService implements IGenerateDaysService {

    private DayReviewDTO dayDayReviewDTO;

    @Autowired
    public GenerateDaysService(DayReviewService dayReviewService) {
        this.dayDayReviewDTO = dayDayReviewDTO;
    }

    @Override
    public void generateWeek(DayObject day) throws ParseException {
        List<String> daysToBeGenerated = new ArrayList<>();
        daysToBeGenerated.add(new SimpleDateFormat("dd/MM/yyyy").parse(day.getDate()).toString().substring(0, 10));

        Integer dayIndex = Integer.parseInt(day.getDate().substring(0, 2));

        for (int index = 0; index < 6; index++) {
            dayIndex++;
            String dateToBeAdded = dayIndex + day.getDate().substring(2);
            daysToBeGenerated.add(new SimpleDateFormat("dd/MM/yyyy").parse(dateToBeAdded).toString().substring(0, 10));
        }


        List<DayReview> dayReviewListGeneration = createDefaultDayReviewListFrom(daysToBeGenerated);
        dayDayReviewDTO.save(new DayReview().builder().date("r").build());

    }

    private List<DayReview> createDefaultDayReviewListFrom(List<String> daysToBeGenerated) {
        List<DayReview> dayReviewList = new ArrayList<>();
        for (String day : daysToBeGenerated) {
            DayReview dayReviewDefault = DayReview.builder()
                    .date(day)
                    .build();
            dayReviewList.add(dayReviewDefault);
        }
        return dayReviewList;
    }
}
