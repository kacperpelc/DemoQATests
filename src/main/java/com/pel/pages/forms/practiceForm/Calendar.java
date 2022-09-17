package com.pel.pages.forms.practiceForm;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
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
        String monthXpath = String.format("//option[contains(text(), '%s')]", monthName);
        driver.findElement(By.xpath(monthXpath)).click();
        return new Calendar();
    }

    public Calendar selectYearFromList(String yearName) {
        String yearXpath = String.format("//option[contains(text(), '%s')]", yearName);
        driver.findElement(By.xpath(yearXpath)).click();
        return new Calendar();
    }

    public PracticeForm selectDay(int day) {
        String dayXpath = String.format("//div[contains(@class, 'react-datepicker__day') and not(contains(@class, '--outside-month')) and contains(text(), '%d')]", day);
        driver.findElement(By.xpath(dayXpath)).click();
        return new PracticeForm();
    }
}
