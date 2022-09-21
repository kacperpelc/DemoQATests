package com.pel.pages.elements.linksPage;

import com.pel.foundation.PageObject;
import com.pel.pages.alertsFrameWindows.browserWindowsPage.NewTab;
import com.pel.utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinksPage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();
    Tab tab = new Tab();

    @FindBy(id = "simpleLink")
    private WebElement home;

    @FindBy(id = "dynamicLink")
    private WebElement homeDynamic;

    @FindBy(id = "created")
    private WebElement createdLink;

    @FindBy(id = "no-content")
    private WebElement noContentButton;

    @FindBy(id = "moved")
    private WebElement movedButton;

    @FindBy(id = "bad-request")
    private WebElement badRequestButton;

    @FindBy(id = "unauthorized")
    private WebElement unauthorizedButton;

    @FindBy(id = "forbidden")
    private WebElement forbiddenButton;

    @FindBy(id = "invalid-url")
    private WebElement invalidUrlButton;

    @FindBy(id = "linkResponse")
    private WebElement response;

    public NewTab clickHomeButton() {
        waitScrollClick(home);
        tab.switchToTab(2);
        return new NewTab();
    }

    public NewTab clickHomeDynamicButton() {
        waitScrollClick(homeDynamic);
        tab.switchToTab(2);
        return new NewTab();
    }

    public LinksPage clickCreatedLinkButton() {
        waitScrollClick(createdLink);
        return new LinksPage();
    }

    public LinksPage clickNoContentButton() {
        waitScrollClick(noContentButton);
        return new LinksPage();
    }

    public LinksPage clickMovedButtonButton() {
        waitScrollClick(movedButton);
        return new LinksPage();
    }

    public LinksPage clickBadRequestButton() {
        waitScrollClick(badRequestButton);
        return new LinksPage();
    }

    public LinksPage clickUnauthorizedButton() {
        waitScrollClick(unauthorizedButton);
        return new LinksPage();
    }

    public LinksPage clickForbiddenButton() {
        waitScrollClick(forbiddenButton);
        return new LinksPage();
    }

    public LinksPage clickInvalidUrlButton() {
        waitScrollClick(invalidUrlButton);
        return new LinksPage();
    }

    private void waitScrollClick(WebElement element) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, element);
        javaScript.scrollToElement(element);
        element.click();
    }

    public LinksPage checkIfResponseContains(int code, String status) {
        fluentWait.sleep(1);    // delay needed
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, response);
        String expectedResponse = String.format("Link has responded with staus %d and status text %s", code, status);
        check.checkIfElementEqualsText(response, expectedResponse);
        return new LinksPage();
    }
}
