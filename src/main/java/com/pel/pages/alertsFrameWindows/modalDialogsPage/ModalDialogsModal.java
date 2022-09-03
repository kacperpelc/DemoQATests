package com.pel.pages.alertsFrameWindows.modalDialogsPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalDialogsModal extends PageObject {
    FluentWait fluentWait = new FluentWait();

    @FindBy(className = "modal-header")
    private WebElement modalHeader;

    @FindBy(className = "modal-body")
    private WebElement modalBody;

    @FindBy(xpath = "//div[@class='modal-content']//button[contains(text(), 'Close')]")
    private WebElement closeButton;

    @FindBy(xpath = "//div[@class='modal-content']//button[@class='close']")
    private WebElement xButton;

    public ModalDialogsModal checkIfHeaderContainsText(String expectedText) {
        checkIfElementContainsText(modalHeader, expectedText);
        return new ModalDialogsModal();
    }

    public ModalDialogsModal checkIfBodyContainsText(String expectedText) {
        checkIfElementContainsText(modalBody, expectedText);
        return new ModalDialogsModal();
    }

    private void checkIfElementContainsText(WebElement element, String expectedText) {
        if(!element.getText().contains(expectedText))
            throw new NoSuchElementException(String.format("expected text: %s, but actual text is: %s", expectedText, element.getText()));
    }

    public ModalDialogsPage closeModalXButton() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, xButton);
        xButton.click();
        return new ModalDialogsPage();
    }

    public ModalDialogsPage closeModalCloseButton() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, closeButton);
        closeButton.click();
        return new ModalDialogsPage();
    }
}
