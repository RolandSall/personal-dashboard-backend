package com.rolandsalloum.personaldashboardbackend.services.GenerateDaysService;

import com.rolandsalloum.personaldashboardbackend.controllers.GenerateDaysController.DayObject;
import com.rolandsalloum.personaldashboardbackend.models.DayReview;
import com.rolandsalloum.personaldashboardbackend.repositories.DayReviewDTO;
import com.rolandsalloum.personaldashboardbackend.services.DayReviewService.DayReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class GenerateDaysService implements IGenerateDaysService {

    private final DayReviewDTO dayReviewDTO;
    private Calendar c = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");



    @Autowired
    public GenerateDaysService(DayReviewDTO dayReviewDTO) {
        this.dayReviewDTO = dayReviewDTO;
    }

    @Override
    public void generateWeek(DayObject day) throws ParseException {
        List<Date> formattedDaysDateToBeGenerated = new ArrayList<>();
        c.setTime(sdf.parse(day.getDate()));

        formattedDaysDateToBeGenerated.add(c.getTime());

        for (int index = 1; index < 7; index++) {
            c.setTime(sdf.parse(day.getDate()));
            c.add(Calendar.DATE, index);


            formattedDaysDateToBeGenerated.add(c.getTime());

        }

        List<DayReview> dayReviewListGeneration = createDefaultDayReviewListFrom(formattedDaysDateToBeGenerated);
        dayReviewDTO.saveAll(dayReviewListGeneration);

    }

    private List<DayReview> createDefaultDayReviewListFrom(List<Date> daysToBeGenerated) throws ParseException {
        List<DayReview> dayReviewList = new ArrayList<>();
        for (Date dayDate : daysToBeGenerated) {
            DayReview dayReviewDefault = DayReview.builder()
                    .date(dayDate)
                    .formattedDay(dayDate.toString())
                    .morningHabit(false)
                    .note(null)
                    .WakeUpEarly(false)
                    .reading(false)
                    .training(false)
                    .defaultSetting(true)
                    .build();
            dayReviewList.add(dayReviewDefault);
        }
        return dayReviewList;
    }
}
