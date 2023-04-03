package com.pel.widgets;

import com.pel.foundation.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("widgets"), @Tag("datePicker")})

public class DatePickerTest extends Base {
    @Tag("631")
    @DisplayName("Date picker test")
    @Test
    public void datePickerTest1() {
        int year = 1993;
        String month = "May";
        int day = 29;
        mainPage()
                .openDemoQA()
                .clickWidgets()
                .clickDatePickerPage()
                .clickDatePicker()
                .selectMonthFromList(month)
                .selectYearFromList(year)
                .selectDayAndGoToDatePickerPage(day)
                .checkIfSelectDateEquals(day, month, year);
    }
    @Tag("632")
    @DisplayName("Date time picker test")
    @Test
    public void datePickerTest2() {
        int year = 1993;
        String month = "May";
        int day = 29;
        String time = "7:15";
        mainPage()
                .openDemoQA()
                .clickWidgets()
                .clickDatePickerPage()
                .clickDateTimePicker()
                .clickPreviousMonth()
                .clickNextMonth()
                .selectMonthFromList(month)
                .selectYearFromList(year)
                .selectDay(day)
                .selectTime(time)
                .checkIfSelectDateTimeEquals(day, month, year, time);
    }

}
