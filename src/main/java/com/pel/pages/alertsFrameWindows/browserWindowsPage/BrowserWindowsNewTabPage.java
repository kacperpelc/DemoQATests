package com.pel.pages.alertsFrameWindows.browserWindowsPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.JavaScript;
import com.pel.utilities.NewWait;
import com.pel.utilities.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsNewTabPage extends PageObject {
    JavaScript javaScript = new JavaScript();
    NewWait newWait = new NewWait();
    Tab tab = new Tab();

    @FindBy(css = "#sampleHeading")
    private WebElement actualText;

    @FindBy(xpath = "//body/text()")
    private WebElement actualTextBody;

    public BrowserWindowsNewTabPage validateIfElementContainsText(String expectedText) {
        newWait.pollingUntilVisibilityOfElement(1, 15, actualText);
        if(!actualText.getText().contains(expectedText))
            throw new NoSuchElementException(String.format("expected text: %s, but actual text is: %s", expectedText, actualText.getText()));
        return new BrowserWindowsNewTabPage();
    }

    public BrowserWindowsNewTabPage validateIfElementWithMessageContainsText(String expectedText) {
        //TODO make it work
/*
        newWait.pollingUntilVisibilityOfElement(1, 15, actualTextBody);
        if(!actualTextBody.getText().contains(expectedText))
            throw new NoSuchElementException(String.format("expected text: %s, but actual text is: %s", expectedText, actualTextBody.getText()));
*/
        return new BrowserWindowsNewTabPage();
    }

    public BrowserWindowsPage closeTabAndGoBackToBrowserWindowsPage() {
        tab.closeTab();
        tab.switchToTab(1);
        return new BrowserWindowsPage();
    }
}
