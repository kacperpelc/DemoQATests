package com.pel.pages.alertsFrameWindows.alertsPage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.Check;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Alert extends PageObject {
    Check check = new Check();
    private final WebDriver driver = WebDriverPool.getWebDriver();

    public Alert checkIfAlertTextEquals(String text) {
        check.checkIfActualTextEqualsText(getAlertText(), text);
        return new Alert();
    }

    private String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public AlertsPage acceptAlert() {
        driver.switchTo().alert().accept();
        return new AlertsPage();
    }

    public AlertsPage dismissAlert() {
        driver.switchTo().alert().dismiss();
        return new AlertsPage();
    }

    public Alert sendKeysAlert(String keys) {
        driver.switchTo().alert().sendKeys(keys);
        return new Alert();
    }
}
