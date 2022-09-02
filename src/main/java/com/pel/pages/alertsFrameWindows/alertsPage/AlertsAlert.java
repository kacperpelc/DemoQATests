package com.pel.pages.alertsFrameWindows.alertsPage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AlertsAlert extends PageObject {
    private final WebDriver driver = WebDriverPool.getWebDriver();
    public AlertsAlert checkIfAlertTextEquals(String text) {
        if(!getAlertText().equals(text))
            throw new NoSuchElementException(String.format("Expected: %s, Actual: %s", text, getAlertText()));
        return new AlertsAlert();
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

    public AlertsAlert sendKeysAlert(String keys) {
        driver.switchTo().alert().sendKeys(keys);
        return new AlertsAlert();
    }
}
