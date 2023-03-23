package com.pel.pages.widgets.toolTipsPage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends PageObject {
    private final WebDriver driver = WebDriverPool.get();

    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();
    Mouse mouse = new Mouse();

    @FindBy(id = "toolTipButton")
    private WebElement hoverMeToSeeButton;

    @FindBy(id = "toolTipTextField")
    private WebElement hoverMeToSeeInput;

    public ToolTipsPage hoverOnButton() {
        waitAndHover(hoverMeToSeeButton);
        return new ToolTipsPage();
    }

    public ToolTipsPage hoverOnInput() {
        waitAndHover(hoverMeToSeeInput);
        return new ToolTipsPage();
    }

    public ToolTipsPage hoverOnLink(String text) {
        WebElement element = driver.findElement(By.xpath(String.format("//a[contains(text(), '%s')]", text)));
        waitAndHover(element);
        return new ToolTipsPage();
    }

    public ToolTipsPage checkIfButtonAriaContains(String expectedText) {
        check.checkIfElementIsDescribedByAria(hoverMeToSeeButton, expectedText);
        return new ToolTipsPage();
    }

    public ToolTipsPage checkIfInputAriaContains(String expectedText) {
        check.checkIfElementIsDescribedByAria(hoverMeToSeeInput, expectedText);
        return new ToolTipsPage();
    }

    public ToolTipsPage checkIfLinkAriaContains(String text, String expectedText) {
        WebElement element = driver.findElement(By.xpath(String.format("//a[contains(text(), '%s')]", text)));
        check.checkIfElementIsDescribedByAria(element, expectedText);
        return new ToolTipsPage();
    }

    private void waitAndHover(WebElement element) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, element);
        javaScript.scrollToElement(element);
        mouse.hoverOnElement(element);
        fluentWait.sleep(1);
    }
}
