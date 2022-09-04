package com.pel.pages.alertsFrameWindows.alertsPage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.Check;
import com.pel.utilities.JavaScript;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends PageObject {
    Check check = new Check();
    JavaScript javaScript = new JavaScript();
    FluentWait fluentWait = new FluentWait();

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

    public Alert clickToSeeAlert() {
        waitScrollClickWaitForAlert(buttonAlert, 15);
        return new Alert();
    }

    public Alert clickToSeeAlertAfter5Seconds() {
        waitScrollClickWaitForAlert(buttonAlertAfter5Seconds, 15);
        return new Alert();
    }

    public Alert clickToSeeConfirmBox() {
        waitScrollClickWaitForAlert(buttonConfirmBox, 15);
        return new Alert();
    }

    public Alert clickToSeePromptBox() {
        waitScrollClickWaitForAlert(buttonPromptBox, 15);
        return new Alert();
    }

    private void waitScrollClickWaitForAlert(WebElement element, int seconds) {
        fluentWait.pollingUntilVisibilityOfElement(1, seconds, element);
        javaScript.scrollToElement(element);
        element.click();
        fluentWait.pollingUntilVisibilityOfAlert(1, 15);
    }

    public AlertsPage checkIfMessageAfterConfirmBoxEquals(String message) {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, confirmBoxMessage);
        check.checkIfElementEqualsText(confirmBoxMessage, message);
        return new AlertsPage();
    }

    public AlertsPage checkIfMessageAfterPromptBoxEquals(String message) {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, promptBoxMessage);
        check.checkIfElementEqualsText(promptBoxMessage, message);
        return new AlertsPage();
    }
}
