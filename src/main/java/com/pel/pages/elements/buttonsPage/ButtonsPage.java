package com.pel.pages.elements.buttonsPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.Click;
import com.pel.utilities.JavaScript;
import com.pel.utilities.NewWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends PageObject {
    Check check = new Check();
    Click click = new Click();
    JavaScript javaScript = new JavaScript();
    NewWait newWait = new NewWait();

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickButton;

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement leftClickButton;

    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    private WebElement leftClickMessage;

    public ButtonsPage leftClickOnClickMeButton() {
        waitAndScroll(leftClickButton, 15);
        leftClickButton.click();
        return new ButtonsPage();
    }

    public ButtonsPage rightClickOnRightClickMeButton() {
        waitAndScroll(rightClickButton, 15);
        click.rightClick(rightClickButton);
        return new ButtonsPage();
    }

    public ButtonsPage doubleClickOnDoubleClickMeButton() {
        waitAndScroll(doubleClickButton, 15);
        click.doubleClick(doubleClickButton);
        return new ButtonsPage();
    }

    public ButtonsPage checkIfLeftClickMessageEquals(String expectedText) {
        check.checkIfElementEqualsText(leftClickMessage, expectedText);
        return new ButtonsPage();
    }

    public ButtonsPage checkIfRightClickMessageEquals(String expectedText) {
        check.checkIfElementEqualsText(rightClickMessage, expectedText);
        return new ButtonsPage();
    }

    public ButtonsPage checkIfDoubleClickMessageEquals(String expectedText) {
        check.checkIfElementEqualsText(doubleClickMessage, expectedText);
        return new ButtonsPage();
    }

    private void waitAndScroll(WebElement element, int timeout) {
        newWait.pollingUntilVisibilityOfElement(1, timeout, element);
        javaScript.scrollToElement(element);
    }
}
