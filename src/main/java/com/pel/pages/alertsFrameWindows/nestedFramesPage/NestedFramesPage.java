package com.pel.pages.alertsFrameWindows.nestedFramesPage;

import com.pel.foundation.PageObject;
import com.pel.pages.alertsFrameWindows.framesPage.Frame;
import com.pel.utilities.JavaScript;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends PageObject {
    private final WebDriver driver = get();
    JavaScript javaScript = new JavaScript();
    FluentWait fluentWait = new FluentWait();

    @FindBy(id = "frame1")
    private WebElement frameBig;

    public Frame goToFrameBig() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, frameBig);
        javaScript.scrollToElement(frameBig);
        driver.switchTo().frame(frameBig);
        return new Frame();
    }
}
