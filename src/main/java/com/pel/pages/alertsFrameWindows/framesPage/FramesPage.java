package com.pel.pages.alertsFrameWindows.framesPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.JavaScript;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends PageObject {
    private final WebDriver driver = getWebDriver();
    JavaScript javaScript = new JavaScript();
    FluentWait fluentWait = new FluentWait();

    @FindBy(id = "frame1")
    private WebElement frameBig;

    @FindBy(id = "frame2")
    private WebElement frameSmall;

    public Frame goToFrameBig() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, frameBig);
        javaScript.scrollToElement(frameBig);
        driver.switchTo().frame(frameBig);
        return new Frame();
    }

    public Frame goToFrameSmall() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, frameSmall);
        javaScript.scrollToElement(frameSmall);
        driver.switchTo().frame(frameSmall);
        return new Frame();
    }

}
