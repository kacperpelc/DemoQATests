package com.pel.pages.forms.practiceForm;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.pages.widgets.datePickerPage.DatePickerPage;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Calendar extends PageObject {
    private final WebDriver driver = WebDriverPool.get();

    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(xpath = "//button[@aria-label='Previous Month']")
    private WebElement previousMonth;

    @FindBy(xpath = "//button[@aria-label='Next Month']")
    private WebElement nextMonth;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthList;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearList;

    public Calendar clickPreviousMonth() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, previousMonth);
        javaScript.scrollToElement(previousMonth);
        previousMonth.click();
        return new Calendar();
    }

    public Calendar clickNextMonth() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, nextMonth);
        javaScript.scrollToElement(nextMonth);
        nextMonth.click();
        return new Calendar();
    }

    public Calendar selectMonthFromList(String monthName) {
        By monthXpath = By.xpath(String.format("//option[contains(text(), '%s')]", monthName));
        driver.findElement(monthXpath).click();
        return new Calendar();
    }

    public Calendar selectYearFromList(int yearName) {
        By yearXpath = By.xpath(String.format("//option[contains(text(), '%s')]", yearName));
        driver.findElement(yearXpath).click();
        return new Calendar();
    }

    public PracticeForm selectDay(int day) {
        By dayXpath = By.xpath(String.format("//div[contains(@class, 'react-datepicker__day') and not(contains(@class, '--outside-month')) and contains(text(), '%d')]", day));
        driver.findElement(dayXpath).click();
        return new PracticeForm();
    }

    public DatePickerPage selectDayAndGoToDatePickerPage(int day) {
        By dayXpath = By.xpath(String.format("//div[contains(@class, 'react-datepicker__day') and not(contains(@class, '--outside-month')) and contains(text(), '%d')]", day));
        javaScript.scrollToElement(driver.findElement(dayXpath));
        driver.findElement(dayXpath).click();
        return new DatePickerPage();
    }
}
