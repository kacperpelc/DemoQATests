package com.pel.pages.elements.radioButtonPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.Mouse;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPage extends PageObject {
    Mouse mouse = new Mouse();
    FluentWait fluentWait = new FluentWait();
    Check check = new Check();

    @FindBy(xpath = "//label[@for='yesRadio']")
    private WebElement yesRadioButton;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    private WebElement impressiveRadioButton;

    @FindBy(xpath = "//label[@for='noRadio']")
    private WebElement noRadioButton;

    @FindBy(xpath = "//div[contains(@class, 'custom-radio')]//following-sibling::p")
    private WebElement radioMessage;

    public RadioButtonPage clickRadioButtonYes() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, yesRadioButton);
        yesRadioButton.click();
        return new RadioButtonPage();
    }

    public RadioButtonPage clickRadioButtonImpressive() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, impressiveRadioButton);
        impressiveRadioButton.click();
        return new RadioButtonPage();
    }

    public RadioButtonPage clickRadioButtonNo() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, noRadioButton);
        noRadioButton.click();
        return new RadioButtonPage();
    }

    public RadioButtonPage checkIfRadioMessageEquals(String expectedText) {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, radioMessage);
        check.checkIfElementEqualsText(radioMessage, expectedText);
        return new RadioButtonPage();
    }

    public RadioButtonPage checkIfRadioButtonNoIsDisabled() {
        check.checkIfElementAttributeContainsValue(noRadioButton, "class", "disabled");
        return new RadioButtonPage();
    }
}
