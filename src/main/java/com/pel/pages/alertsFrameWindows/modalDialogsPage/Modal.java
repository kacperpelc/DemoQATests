package com.pel.pages.alertsFrameWindows.modalDialogsPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Modal extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();

    @FindBy(className = "modal-header")
    private WebElement modalHeader;

    @FindBy(className = "modal-body")
    private WebElement modalBody;

    @FindBy(xpath = "//div[@class='modal-content']//button[contains(text(), 'Close')]")
    private WebElement closeButton;

    @FindBy(xpath = "//div[@class='modal-content']//button[@class='close']")
    private WebElement xButton;

    public Modal checkIfHeaderContainsText(String expectedText) {
        checkIfElementContainsText(modalHeader, expectedText);
        return new Modal();
    }

    public Modal checkIfBodyContainsText(String expectedText) {
        checkIfElementContainsText(modalBody, expectedText);
        return new Modal();
    }

    private void checkIfElementContainsText(WebElement element, String expectedText) {
        check.checkIfElementContainsText(element, expectedText);
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
