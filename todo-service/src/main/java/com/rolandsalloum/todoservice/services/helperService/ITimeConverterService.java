package com.rolandsalloum.todoservice.services.helperService;

import java.text.ParseException;
import java.util.Date;

public interface ITimeConverterService {

    Long convertStringToLongDate(String date) throws ParseException;

    Date convertLongToActualDate(Long date);
}
