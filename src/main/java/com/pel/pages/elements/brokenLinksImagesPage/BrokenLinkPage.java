package com.pel.pages.elements.brokenLinksImagesPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenLinkPage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();

    @FindBy(xpath = "//h3[text()='Status Codes']//following-sibling::p")
    private WebElement textWithStatusCode;

    public BrokenLinkPage checkIfTextContains(String expectedText) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, textWithStatusCode);
        check.checkIfElementContainsText(textWithStatusCode, expectedText);
        return new BrokenLinkPage();
    }
}
