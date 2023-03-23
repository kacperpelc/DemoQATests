package com.pel.utilities;

import com.pel.foundation.WebDriverPool;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Check {
    private final WebDriver driver = WebDriverPool.get();

    public void checkIfElementContainsText(WebElement element, String expectedText) {
        if(!element.getText().contains(expectedText))
            throw new NoSuchElementException(String.format("expected text: \"%s\", but actual text is: \"%s\"", expectedText, element.getText()));
    }

    public void checkIfElementEqualsText(WebElement element, String expectedText) {
        if(!element.getText().equals(expectedText))
            throw new NoSuchElementException(String.format("expected text: \"%s\", but actual text is: \"%s\"", expectedText, element.getText()));
    }

    public void checkIfActualTextEqualsText(String actualText, String expectedText) {
        if(!actualText.equals(expectedText))
            throw new NoSuchElementException(String.format("expected text: \"%s\", but actual text is: \"%s\"", expectedText, actualText));
    }

    public void checkIfElementHasCssValue(WebElement element, String cssProperty, String expectedCssValue) {
        if(!element.getCssValue(cssProperty).contains(expectedCssValue))
            throw new NoSuchElementException(String.format("css property: \"%s\"; expected: \"%s\", but actual is: \"%s\"",
                    cssProperty, expectedCssValue, element.getCssValue(cssProperty)));
    }

    public void checkIfElementAttributeContainsValue(WebElement element, String attribute, String value) {
        if(!element.getAttribute(attribute).contains(value))
            throw new NoSuchElementException(String.format("attribute: \"%s\"; expected: \"%s\", but actual is: \"%s\"",
                   attribute, value, element.getAttribute(attribute)));
    }

    public void checkIfElementIsEnabled(WebElement element) {
        if(!element.isEnabled())
            throw new NoSuchElementException("expected: disabled, actual: enabled");
    }

    public void checkIfElementIsDisabled(WebElement element) {
        if(element.isEnabled())
            throw new NoSuchElementException("expected: enabled, actual: disabled");
    }

    public void checkIfListsAreEqual(List<String> actualResults, List<String> expectedResults) {
        if(!expectedResults.equals(actualResults))
            throw new NoSuchElementException(String.format("expected: \"%s\", actual: \"%s\"", expectedResults, actualResults));
    }

    public void checkIfElementIsDescribedByAria(WebElement element, String expectedText) {
        final String ariaSelectorId = element.getAttribute("aria-describedby");
        final String ariaText = driver.findElement(By.id(ariaSelectorId)).getText();
        if(!ariaText.contains(expectedText))
            throw new NoSuchElementException(String.format("expected text: \"%s\", but actual text is: \"%s\"", expectedText, ariaText));
    }
}
