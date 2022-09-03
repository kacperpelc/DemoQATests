package com.pel.pages.elements.dynamicPropertiesPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicPropertiesPage extends PageObject {
    FluentWait fluentWait = new FluentWait();
    @FindBy(id = "enableAfter")
    private WebElement enableAfterButton;

    @FindBy(id = "colorChange")
    private WebElement colorChangeButton;

    @FindBy(id = "visibleAfter")
    private WebElement visibleAfterButton;

    public DynamicPropertiesPage checkIfEnabledAfterButtonIsEnabled() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, enableAfterButton);
        fluentWait.pollingUntilAttributeTotBeEmpty(1, 15, enableAfterButton, "disabled");
        if(!enableAfterButton.isEnabled())
            throw new NoSuchElementException("expected: enabled, actual: disabled");
        return new DynamicPropertiesPage();
    }

    public DynamicPropertiesPage checkIfElementChangedColor(String color) {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, colorChangeButton);
        fluentWait.pollingUntilAttributeToBe(1, 15, colorChangeButton, "color", color);
        if(colorChangeButton.getAttribute("color").equals(color))
            throw new NoSuchElementException("expected: red, actual: " + colorChangeButton.getAttribute("color"));
        return new DynamicPropertiesPage();
    }

    public DynamicPropertiesPage checkIfVisibleAfterButtonIsVisible() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, visibleAfterButton);
        if(!visibleAfterButton.isDisplayed())
            throw new NoSuchElementException(String.format("expected: %s, but actual is not displayed"));
        return new DynamicPropertiesPage();
    }
}
