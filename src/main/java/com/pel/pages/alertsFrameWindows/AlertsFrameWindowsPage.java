package com.pel.pages.alertsFrameWindows;

import com.pel.foundation.PageObject;
import com.pel.pages.alertsFrameWindows.alertsPage.AlertsPage;
import com.pel.pages.alertsFrameWindows.browserWindowsPage.BrowserWindowsPage;
import com.pel.pages.alertsFrameWindows.framesPage.FramesPage;
import com.pel.pages.alertsFrameWindows.modalDialogsPage.ModalDialogsPage;
import com.pel.pages.alertsFrameWindows.nestedFramesPage.NestedFramesPage;
import com.pel.utilities.JavaScript;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsFrameWindowsPage extends PageObject {
    JavaScript javaScript = new JavaScript();
    FluentWait fluentWait = new FluentWait();

    @FindBy(xpath = "//span[contains(text(), 'Browser Windows')]//ancestor::li[contains(@class, 'btn')]")
    private WebElement browserWindows;

    @FindBy(xpath = "//span[contains(text(), 'Alerts')]//ancestor::li[contains(@class, 'btn')]")
    private WebElement alerts;

    @FindBy(xpath = "//span[contains(text(), 'Frames')]//ancestor::li[contains(@class, 'btn')]")
    private WebElement frames;

    @FindBy(xpath = "//span[contains(text(), 'Nested Frames')]//ancestor::li[contains(@class, 'btn')]")
    private WebElement nestedFrames;

    @FindBy(xpath = "//span[contains(text(), 'Modal Dialogs')]//ancestor::li[contains(@class, 'btn')]")
    private WebElement modalDialogs;

    public BrowserWindowsPage clickBrowserWindows() {
        waitScrollClick(browserWindows, 15);
        return new BrowserWindowsPage();
    }

    public AlertsPage clickAlerts() {
        waitScrollClick(alerts, 15);
        return new AlertsPage();
    }

    public FramesPage clickFrames() {
        waitScrollClick(frames, 15);
        return new FramesPage();
    }

    public NestedFramesPage clickNestedFrames() {
        waitScrollClick(nestedFrames, 15);
        return new NestedFramesPage();
    }

    public ModalDialogsPage clickModalDialogs() {
        waitScrollClick(modalDialogs, 15);
        return new ModalDialogsPage();
    }

    private void waitScrollClick(WebElement element, int seconds) {
        fluentWait.pollingUntilVisibilityOfElement(1, seconds, element);
        javaScript.scrollToElement(element);
        element.click();
    }
}
