package com.pel.pages.alertsFrameWindows;

import com.pel.foundation.PageObject;
import com.pel.pages.bookStoreApplication.BookStorePage;
import com.pel.utilities.JavaScript;
import com.pel.utilities.NewWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsFrameWindowsPage extends PageObject {
    JavaScript javaScript = new JavaScript();
    NewWait newWait = new NewWait();

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
        newWait.pollingUntilVisibilityOfElement(1, 15, browserWindows);
        javaScript.scrollToElement(browserWindows);
        browserWindows.click();
        return new BrowserWindowsPage();
    }

    public AlertsPage clickAlerts() {
        newWait.pollingUntilVisibilityOfElement(1, 15, alerts);
        javaScript.scrollToElement(alerts);
        alerts.click();
        return new AlertsPage();
    }

    public FramesPage clickFrames() {
        newWait.pollingUntilVisibilityOfElement(1, 15, frames);
        javaScript.scrollToElement(frames);
        frames.click();
        return new FramesPage();
    }

    public NestedFramesPage clickNestedFrames() {
        newWait.pollingUntilVisibilityOfElement(1, 15, nestedFrames);
        javaScript.scrollToElement(nestedFrames);
        nestedFrames.click();
        return new NestedFramesPage();
    }

    public ModalDialogsPage clickModalDialogs() {
        newWait.pollingUntilVisibilityOfElement(1, 15, modalDialogs);
        javaScript.scrollToElement(modalDialogs);
        modalDialogs.click();
        return new ModalDialogsPage();
    }
}
