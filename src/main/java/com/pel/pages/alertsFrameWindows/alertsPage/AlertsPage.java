package com.pel.pages.alertsFrameWindows.alertsPage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.JavaScript;
import com.pel.utilities.NewWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends PageObject {
    JavaScript javaScript = new JavaScript();
    NewWait newWait = new NewWait();

    private final WebDriver driver = WebDriverPool.getWebDriver();

    @FindBy(id = "alertButton")
    private WebElement buttonAlert;

    @FindBy(id = "timerAlertButton")
    private WebElement buttonAlertAfter5Seconds;

    @FindBy(id = "confirmButton")
    private WebElement buttonConfirmBox;

    @FindBy(id = "promtButton")
    private WebElement buttonPromptBox;

    @FindBy(id = "confirmResult")
    private WebElement confirmBoxMessage;

    @FindBy(id = "promptResult")
    private WebElement promptBoxMessage;

    public AlertsAlert clickToSeeAlert() {
        waitScrollClickWaitForAlert(buttonAlert, 15);
        return new AlertsAlert();
    }

    public AlertsAlert clickToSeeAlertAfter5Seconds() {
        waitScrollClickWaitForAlert(buttonAlertAfter5Seconds, 15);
        return new AlertsAlert();
    }

    public AlertsAlert clickToSeeConfirmBox() {
        waitScrollClickWaitForAlert(buttonConfirmBox, 15);
        return new AlertsAlert();
    }

    public AlertsAlert clickToSeePromptBox() {
        waitScrollClickWaitForAlert(buttonPromptBox, 15);
        return new AlertsAlert();
    }

    private void waitScrollClickWaitForAlert(WebElement element, int seconds) {
        newWait.pollingUntilVisibilityOfElement(1, seconds, element);
        javaScript.scrollToElement(element);
        element.click();
        newWait.pollingUntilVisibilityOfAlert(1, 15);
    }

    public AlertsPage checkIfMessageAfterConfirmBoxEquals(String message) {
        newWait.pollingUntilVisibilityOfElement(1, 15, confirmBoxMessage);
        if(!confirmBoxMessage.getText().equals(message))
            throw new NoSuchElementException(String.format("Expected: %s, Actual: %s", confirmBoxMessage.getText(), message));
        return new AlertsPage();
    }

    public AlertsPage checkIfMessageAfterPromptBoxEquals(String message) {
        newWait.pollingUntilVisibilityOfElement(1, 15, promptBoxMessage);
        if(!promptBoxMessage.getText().equals(message))
            throw new NoSuchElementException(String.format("Expected: %s, Actual: %s", promptBoxMessage.getText(), message));
        return new AlertsPage();
    }
}
