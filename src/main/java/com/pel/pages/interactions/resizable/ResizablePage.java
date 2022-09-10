package com.pel.pages.interactions.resizable;

import com.pel.foundation.PageObject;
import com.pel.utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResizablePage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();
    Mouse mouse = new Mouse();

    @FindBy(id = "resizableBoxWithRestriction")
    private WebElement resizableRectangle;

    @FindBy(xpath = "//div[@class='constraint-area']//span[contains(@class, 'react-resizable-handle')]")
    private WebElement resizableHandle;

    @FindBy(xpath = "//div[@class='constraint-area']//div[@class='text']")
    private WebElement resizableText;

    @FindBy(id = "resizable")
    private WebElement resizableRectangleNoLimit;

    @FindBy(xpath = "//div[@id='resizable']//div")
    private WebElement resizableTextNoLimit;


    @FindBy(xpath = "//div[@id='resizable']//span")
    private WebElement resizableHandleNoLimit;

    public ResizablePage dragAndDrop(int x, int y) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, resizableHandle);
        mouse.dragAndDrop(resizableHandle, x, y);
        return new ResizablePage();
    }

    public ResizablePage checkIfElementContainsText(String expectedText) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, resizableText);
        javaScript.scrollToElement(resizableText);
        check.checkIfElementContainsText(resizableText, expectedText);
        return new ResizablePage();
    }

    public ResizablePage checkIfElementsDimensionsEquals(int width, int height) {
        check.checkIfElementHasCssValue(resizableRectangle, "width", width+"px");
        check.checkIfElementHasCssValue(resizableRectangle, "height", height+"px");
        return new ResizablePage();
    }

    public ResizablePage dragAndDropNoLimit(int x, int y) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, resizableHandleNoLimit);
        mouse.dragAndDrop(resizableHandleNoLimit, x, y);
        return new ResizablePage();
    }

    public ResizablePage checkIfElementNoLimitEqualsText(String expectedText) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, resizableTextNoLimit);
        javaScript.scrollToElement(resizableTextNoLimit);
        check.checkIfElementEqualsText(resizableTextNoLimit, expectedText);
        return new ResizablePage();
    }

    public ResizablePage checkIfElementsNoLimitDimensionsEquals(int width, int height) {
        check.checkIfElementHasCssValue(resizableRectangleNoLimit, "width", width+"px");
        check.checkIfElementHasCssValue(resizableRectangleNoLimit, "height", height+"px");
        return new ResizablePage();
    }
}
