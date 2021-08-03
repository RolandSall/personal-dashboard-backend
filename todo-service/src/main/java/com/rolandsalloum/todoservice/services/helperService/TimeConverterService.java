package com.rolandsalloum.todoservice.services.helperService;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class TimeConverterService implements ITimeConverterService{


    private final Calendar c = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Long convertStringToLongDate(String date) throws ParseException {
        c.setTime(sdf.parse(date));
        return c.getTimeInMillis();
    }

    @Override
    public Date convertLongToActualDate(Long timeStamp) {
        Date date = new Date(timeStamp);
        return date;
    }
}
