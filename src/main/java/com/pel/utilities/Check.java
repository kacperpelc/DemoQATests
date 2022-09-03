package com.pel.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Check {
    public void checkIfElementContainsText(WebElement element, String expectedText) {
        if(!element.getText().contains(expectedText))
            throw new NoSuchElementException(String.format("expected text: %s, but actual text is: %s", expectedText, element.getText()));
    }

    public void checkIfElementEqualsText(WebElement element, String expectedText) {
        if(!element.getText().equals(expectedText))
            throw new NoSuchElementException(String.format("expected text: %s, but actual text is: %s", expectedText, element.getText()));
    }
}
