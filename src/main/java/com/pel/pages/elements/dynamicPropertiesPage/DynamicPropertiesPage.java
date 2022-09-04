package com.pel.pages.elements.dynamicPropertiesPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicPropertiesPage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    @FindBy(id = "enableAfter")
    private WebElement enableAfterButton;

    @FindBy(id = "colorChange")
    private WebElement colorChangeButton;

    @FindBy(id = "visibleAfter")
    private WebElement visibleAfterButton;

    public DynamicPropertiesPage checkIfEnabledAfterButtonIsEnabled() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, enableAfterButton);
        fluentWait.pollingUntilAttributeToBeEmpty(1, 15, enableAfterButton, "disabled");
        check.checkIfElementIsEnabled(enableAfterButton);
        return new DynamicPropertiesPage();
    }

    public DynamicPropertiesPage checkIfElementChangedColor(String color) {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, colorChangeButton);
        fluentWait.pollingUntilAttributeToNotBeEmpty(1, 15, colorChangeButton, "color");
        check.checkIfElementHasCssValue(colorChangeButton, "color", color);
        return new DynamicPropertiesPage();
    }

    public DynamicPropertiesPage checkIfVisibleAfterButtonIsVisible() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, visibleAfterButton);
        return new DynamicPropertiesPage();
    }
}
