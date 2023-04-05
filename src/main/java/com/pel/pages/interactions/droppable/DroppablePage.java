package com.pel.pages.interactions.droppable;

import com.pel.foundation.PageObject;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends PageObject {
    FluentWait fluentWait = new FluentWait();

    @FindBy(css = "a#droppableExample-tab-simple")
    private WebElement simpleTab;

    @FindBy(css = "a#droppableExample-tab-accept")
    private WebElement acceptTab;

    @FindBy(css = "a#droppableExample-tab-preventPropogation")
    private WebElement preventPropagationTab;

    @FindBy(css = "a#droppableExample-tab-revertable")
    private WebElement revertDraggableTab;

    public DroppableSimplePage clickOnSimpleTab() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, simpleTab);
        simpleTab.click();
        return new DroppableSimplePage();
    }

    public DroppableAcceptPage clickOnAcceptTab() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, acceptTab);
        acceptTab.click();
        return new DroppableAcceptPage();
    }

    public DroppablePreventPropagationPage clickOnPreventPropagationTab() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, preventPropagationTab);
        preventPropagationTab.click();
        return new DroppablePreventPropagationPage();
    }

    public DroppableRevertPage clickOnRevertDraggableTab() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, simpleTab);
        simpleTab.click();
        return new DroppableRevertPage();
    }
}
