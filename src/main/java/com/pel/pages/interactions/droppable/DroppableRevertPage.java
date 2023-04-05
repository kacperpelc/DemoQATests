package com.pel.pages.interactions.droppable;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.Mouse;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppableRevertPage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    Mouse mouse = new Mouse();

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='revertable']")
    private WebElement revertableBox;

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='notRevertable']")
    private WebElement notRevertableBox;

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='droppable']")
    private WebElement droppableBox;

    public DroppableRevertPage dragAndDropRevertableBox() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, revertableBox);
        mouse.dragAndDrop(revertableBox, droppableBox);
        return new DroppableRevertPage();
    }

    public DroppableRevertPage dragAndDropNotRevertableBox() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, notRevertableBox);
        mouse.dragAndDrop(notRevertableBox, droppableBox);
        return new DroppableRevertPage();
    }

    public DroppableRevertPage checkIfDropBoxCameToBase() {
        fluentWait.sleep(1);
        check.checkIfElementHasCssValue(revertableBox, "left", "0");
        check.checkIfElementHasCssValue(revertableBox, "top", "0");
        return new DroppableRevertPage();
    }

    public DroppableRevertPage checkIfDropBoxStayedInDroppable() {
        fluentWait.sleep(1);
        final Point baseCords = droppableBox.getLocation();
        fluentWait.sleep(5);
        final Point finalCords = droppableBox.getLocation();
        if (finalCords.x != baseCords.x || finalCords.y != baseCords.y)
            throw new NoSuchElementException(String.format("expected location: \"%s\", but actual location is: \"%s\"", baseCords, finalCords));
        return new DroppableRevertPage();
    }

    public DroppableRevertPage checkIfBoxIsDroppedCorrectly(String color) {
        check.checkIfElementHasCssValue(droppableBox, "background-color", color);
        return new DroppableRevertPage();
    }
}
