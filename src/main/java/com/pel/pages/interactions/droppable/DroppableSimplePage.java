package com.pel.pages.interactions.droppable;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.Mouse;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppableSimplePage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    Mouse mouse = new Mouse();

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='draggable']")
    private WebElement draggableBox;

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='droppable']")
    private WebElement droppableBox;

    public DroppableSimplePage dragAndDropBox() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, draggableBox);
        mouse.dragAndDrop(draggableBox, droppableBox);
        return new DroppableSimplePage();
    }

    public DroppableSimplePage checkIfDroppableBoxColorEquals(String color) {
        check.checkIfElementHasCssValue(droppableBox, "background-color", color);
        return new DroppableSimplePage();
    }
}
