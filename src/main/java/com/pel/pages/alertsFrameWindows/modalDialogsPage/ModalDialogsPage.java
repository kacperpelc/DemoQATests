package com.pel.pages.alertsFrameWindows.modalDialogsPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.JavaScript;
import com.pel.utilities.NewWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalDialogsPage extends PageObject {
    private final WebDriver driver = getWebDriver();
    NewWait newWait = new NewWait();

    @FindBy(id = "showSmallModal")
    private WebElement smallModalButton;

    @FindBy(id = "showLargeModal")
    private WebElement largeModalButton;

    public ModalDialogsModal clickSmallModalButton() {
        newWait.pollingUntilVisibilityOfElement(1, 15, smallModalButton);
        smallModalButton.click();
        return new ModalDialogsModal();
    }

    public ModalDialogsModal clickLargeModalButton() {
        newWait.pollingUntilVisibilityOfElement(1, 15, largeModalButton);
        largeModalButton.click();
        return new ModalDialogsModal();
    }
}