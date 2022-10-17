package com.pel.pages.widgets.datePickerPage;

import com.pel.foundation.PageObject;
import com.pel.pages.forms.practiceForm.Calendar;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Month;

public class DatePickerPage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();

    @FindBy(id = "datePickerMonthYearInput")
    private WebElement datePicker;

    @FindBy(id = "dateAndTimePickerInput")
    private WebElement dateTimePicker;

    public Calendar clickDatePicker() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, datePicker);
        datePicker.click();
        return new Calendar();
    }

    public DateTimePicker clickDateTimePicker() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, dateTimePicker);
        dateTimePicker.click();
        return new DateTimePicker();
    }

    public DatePickerPage checkIfSelectDateEquals(int day, String month, int year) {
        int monthInt = Month.valueOf(month.toUpperCase()).getValue();
        check.checkIfElementAttributeContainsValue(datePicker, "value", String.format("%s/%d/%d", monthInt, day, year));
        return new DatePickerPage();
    }

    public DatePickerPage checkIfSelectDateTimeEquals(int day, String month, int year, String time) {
        int hours = Integer.parseInt(time.substring(0, time.indexOf(":")));
        String timeNew;
        System.out.println("aaa"+hours);

        if (hours < 12)
            timeNew = time + " AM";
        else {
            timeNew = time.replace(String.valueOf(hours), String.valueOf(hours-12));
            timeNew += " PM";
        }
        check.checkIfElementAttributeContainsValue(dateTimePicker, "value", String.format("%s %d, %d %s", month, day, year, timeNew));
        return new DatePickerPage();
    }
}
