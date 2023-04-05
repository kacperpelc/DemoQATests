package com.pel.pages.interactions.droppable;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.Mouse;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppableAcceptPage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    Mouse mouse = new Mouse();

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='notAcceptable']")
    private WebElement notAcceptableBox;

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='acceptable']")
    private WebElement acceptableBox;

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='droppable']")
    private WebElement droppableBox;

    public DroppableAcceptPage dragAndDropAcceptableBox() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, acceptableBox);
        mouse.dragAndDrop(acceptableBox, droppableBox);
        return new DroppableAcceptPage();
    }

    public DroppableAcceptPage dragAndDropNotAcceptableBox() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, notAcceptableBox);
        mouse.dragAndDrop(notAcceptableBox, droppableBox);
        return new DroppableAcceptPage();
    }

    public DroppableAcceptPage checkIfBoxIsDroppedCorrectly(String color) {
//        fluentWait.sleep(5);
        check.checkIfElementHasCssValue(droppableBox, "background-color", color);
        return new DroppableAcceptPage();
    }
}
