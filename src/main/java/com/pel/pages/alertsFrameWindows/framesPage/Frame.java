package com.pel.pages.alertsFrameWindows.framesPage;

import com.pel.foundation.PageObject;
import com.pel.pages.alertsFrameWindows.nestedFramesPage.NestedFramesPage;
import com.pel.utilities.Check;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Frame extends PageObject {
    private final WebDriver driver = get();
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();

    @FindBy(tagName = "h1")
    private WebElement actualText;

    @FindBy(xpath = "//body")
    private WebElement actualTextBody;

    @FindBy(xpath = "//iframe[@srcdoc]")
    private WebElement frameInner;

    public Frame validateIfElementContainsText(String expectedText) {
        validateIfElementContainsText(actualText, expectedText);
        return new Frame();
    }

    public Frame validateIfElementBodyContainsText(String expectedText) {
        validateIfElementContainsText(actualTextBody, expectedText);
        return new Frame();
    }

    private void validateIfElementContainsText(WebElement element, String expectedText) {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, element);
        check.checkIfElementContainsText(element, expectedText);
    }

    public Frame goToInnerFrame() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, frameInner);
        driver.switchTo().frame(frameInner);
        return new Frame();
    }

    public Frame goToOuterFrame() {
        driver.switchTo().parentFrame();
        return new Frame();
    }

    public FramesPage closeFrameAndGoBackToFramesPage() {
        driver.switchTo().defaultContent();
        return new FramesPage();
    }

    public NestedFramesPage closeFrameAndGoBackToNestedFramesPage() {
        driver.switchTo().defaultContent();
        return new NestedFramesPage();
    }
}
