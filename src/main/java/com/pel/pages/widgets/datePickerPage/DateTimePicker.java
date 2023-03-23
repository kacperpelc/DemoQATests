package com.pel.pages.widgets.datePickerPage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class DateTimePicker extends PageObject {
    private final WebDriver driver = WebDriverPool.get();

    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(xpath = "//button[@aria-label='Previous Month']")
    private WebElement previousMonth;

    @FindBy(xpath = "//button[@aria-label='Next Month']")
    private WebElement nextMonth;

    @FindBy(xpath = "//div[@class='react-datepicker__month-read-view']")
    private WebElement monthList;

    @FindBy(xpath = "//div[@class='react-datepicker__year-read-view']")
    private WebElement yearList;

    public DateTimePicker clickPreviousMonth() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, previousMonth);
        javaScript.scrollToElement(previousMonth);
        previousMonth.click();
        return new DateTimePicker();
    }

    public DateTimePicker clickNextMonth() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, nextMonth);
        javaScript.scrollToElement(nextMonth);
        nextMonth.click();
        return new DateTimePicker();
    }

    public DateTimePicker selectMonthFromList(String monthName) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, monthList);
        monthList.click();
        By monthXpath = By.xpath(String.format("//div[text()='%s']", monthName));
        driver.findElement(monthXpath).click();
        return new DateTimePicker();
    }

    public DateTimePicker selectYearFromList(int yearName) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, yearList);
        yearList.click();

        By yearMaxXpath = By.xpath("//div[contains(@class, '__year-option') and not(a)][1]");
        By yearMinXpath = By.xpath("//div[contains(@class, '__year-option') and not(a)][last()]");

        By yearXpath = By.xpath(String.format("//div[text()='%d']", yearName));
        while (true) {
            try {
                if (yearName > Integer.parseInt(driver.findElement(yearMaxXpath).getText().replaceAll("[^\\d.]", ""))) {
                    By arrowUpXpath = By.xpath("//div[contains(@class, '__year-option') and a][1]");
                    javaScript.scrollToElement(driver.findElement(arrowUpXpath));
                    driver.findElement(arrowUpXpath).click();
                }
                else if (yearName < Integer.parseInt(driver.findElement(yearMinXpath).getText().replaceAll("[^\\d.]", ""))) {
                    By arrowDownXpath = By.xpath("//div[contains(@class, '__year-option') and a][last()]");
                    javaScript.scrollToElement(driver.findElement(arrowDownXpath));
                    driver.findElement(arrowDownXpath).click();
                }

                driver.findElement(yearXpath).click();
                return new DateTimePicker();
            } catch(NoSuchElementException noSuchElementException) {
            }
        }
    }

    public DateTimePicker selectDay(int day) {
        By dayXpath = By.xpath(String.format("//div[contains(@class, 'react-datepicker__day') and not(contains(@class, '--outside-month')) and contains(text(), '%d')]", day));
        driver.findElement(dayXpath).click();
        return new DateTimePicker();
    }

    public DatePickerPage selectTime(String time) {
        By timeXpath = By.xpath(String.format("//li[contains(@class, 'react-datepicker__time') and contains(text(), '%s')]", time));
        driver.findElement(timeXpath).click();
        return new DatePickerPage();
    }
}
