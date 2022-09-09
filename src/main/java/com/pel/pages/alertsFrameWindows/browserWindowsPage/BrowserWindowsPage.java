package com.pel.pages.alertsFrameWindows.browserWindowsPage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.JavaScript;
import com.pel.utilities.FluentWait;
import com.pel.utilities.Tab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPage extends PageObject {
    JavaScript javaScript = new JavaScript();
    FluentWait fluentWait = new FluentWait();
    Tab tab = new Tab();
    private final WebDriver driver = WebDriverPool.get();
    @FindBy(css = "#tabButton")
    private WebElement newTabButton;

    @FindBy(css = "#windowButton")
    private WebElement newWindowButton;

    @FindBy(css = "#messageWindowButton")
    private WebElement newWindowMessageButton;

    public NewTab openNewTab() {
        waitAndClick(newTabButton, 15);
        tab.switchToTab(2);
        return new NewTab();
    }

    public NewTab openNewWindow() {
        waitAndClick(newWindowButton, 15);
        tab.switchToTab(2);
        return new NewTab();
    }

    public NewTab openNewWindowWithMessage() {
        waitAndClick(newWindowMessageButton, 15);
        tab.switchToTab(2);
        return new NewTab();
    }

    private void waitAndClick(WebElement element, int timeout) {
        fluentWait.pollingUntilVisibilityOfElement(1, timeout, element);
        element.click();
    }

    public BrowserWindowsPage goBackToBrowserWindowsPage() {
        tab.switchToTab(1);
        return new BrowserWindowsPage();
    }
}
