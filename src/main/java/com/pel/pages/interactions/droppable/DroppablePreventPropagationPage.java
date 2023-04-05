package com.pel.pages.interactions.droppable;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.Mouse;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppablePreventPropagationPage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    Mouse mouse = new Mouse();

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='dragBox']")
    private WebElement draggableBox;

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='notGreedyDropBox']")
    private WebElement droppableNotGreedyOuter;

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='notGreedyInnerDropBox']")
    private WebElement droppableNotGreedyInner;

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='greedyDropBox']")
    private WebElement droppableGreedyOuter;

    @FindBy(xpath = "//div[contains(@class, 'active')]//div[@id='greedyDropBoxInner']")
    private WebElement droppableGreedyInner;

    public DroppablePreventPropagationPage dragAndDropBox(String greedy) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, draggableBox);

        WebElement droppable;
        switch (greedy) {
            case "not greedy":
                droppable = droppableNotGreedyInner;
                break;
            case "greedy":
                droppable = droppableGreedyInner;
                break;
            default:
                droppable = draggableBox;
                break;
        }
        mouse.dragAndDrop(draggableBox, droppable);
        return new DroppablePreventPropagationPage();
    }

    public DroppablePreventPropagationPage checkIfBoxIsDroppedCorrectly(String greedy, String innerOuter, String color) {
        WebElement droppable;
        switch (greedy) {
            case "not greedy":
                if (innerOuter.equals("outer"))
                    droppable = droppableNotGreedyOuter;
                else
                    droppable = droppableNotGreedyInner;
                break;
            case "greedy":
                if (innerOuter.equals("outer"))
                    droppable = droppableGreedyOuter;
                else
                    droppable = droppableGreedyInner;
                break;
            default:
                droppable = draggableBox;
                break;
        }
        check.checkIfElementHasCssValue(droppable, "background-color", color);
        return new DroppablePreventPropagationPage();
    }
}