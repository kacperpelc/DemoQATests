package com.pel.pages.alertsFrameWindows.browserWindowsPage;

import com.pel.foundation.PageObject;
import com.pel.pages.elements.linksPage.LinksPage;
import com.pel.utilities.Check;
import com.pel.utilities.JavaScript;
import com.pel.utilities.FluentWait;
import com.pel.utilities.Tab;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTab extends PageObject {
    Check check = new Check();
    JavaScript javaScript = new JavaScript();
    FluentWait fluentWait = new FluentWait();
    Tab tab = new Tab();

    @FindBy(css = "#sampleHeading")
    private WebElement actualText;

    @FindBy(xpath = "//body")
    private WebElement actualTextBody;

    public NewTab validateIfElementContainsText(String expectedText) {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, actualText);
        check.checkIfElementContainsText(actualText, expectedText);
        return new NewTab();
    }

    public NewTab validateIfElementWithMessageContainsText(String expectedText) {
        //TODO make it work
        fluentWait.pollingUntilVisibilityOfElement(1, 15, actualTextBody);
        check.checkIfElementContainsText(actualTextBody, expectedText);
        fluentWait.sleep(2);
        return new NewTab();
    }

    public BrowserWindowsPage closeTabAndGoBackToBrowserWindowsPage() {
        tab.closeTab();
        tab.switchToTab(1);
        return new BrowserWindowsPage();
    }

    public LinksPage closeTabAndGoBackToLinksPage() {
        tab.closeTab();
        tab.switchToTab(1);
        return new LinksPage();
    }
}
