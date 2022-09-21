package com.pel.pages.alertsFrameWindows.modalDialogsPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalDialogsPage extends PageObject {
    private final WebDriver driver = get();
    FluentWait fluentWait = new FluentWait();

    @FindBy(id = "showSmallModal")
    private WebElement smallModalButton;

    @FindBy(id = "showLargeModal")
    private WebElement largeModalButton;

    public Modal clickSmallModalButton() {
        fluentWait.sleep(1);
        fluentWait.pollingUntilVisibilityOfElement(1, 15, smallModalButton);
        smallModalButton.click();
        return new Modal();
    }

    public Modal clickLargeModalButton() {
        fluentWait.sleep(1);
        fluentWait.pollingUntilVisibilityOfElement(1, 15, largeModalButton);
        largeModalButton.click();
        return new Modal();
    }
}
