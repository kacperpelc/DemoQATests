package com.pel.pages.interactions;

import com.pel.foundation.PageObject;
import com.pel.pages.interactions.draggable.DraggablePage;
import com.pel.pages.interactions.droppable.DroppablePage;
import com.pel.pages.interactions.resizable.ResizablePage;
import com.pel.pages.interactions.selectable.SelectablePage;
import com.pel.pages.interactions.sortable.SortablePage;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InteractionsPage extends PageObject {
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();
    @FindBy(xpath = "//span[contains(text(), 'Sortable')]//parent::li")
    private WebElement sortable;

    @FindBy(xpath = "//span[contains(text(), 'Selectable')]//parent::li")
    private WebElement selectable;

    @FindBy(xpath = "//span[contains(text(), 'Resizable')]//parent::li")
    private WebElement resizable;

    @FindBy(xpath = "//span[contains(text(), 'Droppable')]//parent::li")
    private WebElement droppable;

    @FindBy(xpath = "//span[contains(text(), 'Dragabble')]//parent::li")
    private WebElement dragabble;


    public SortablePage clickSortable() {
        waitScrollClick(sortable, 15);
        return new SortablePage();
    }

    public SelectablePage clickSelectable() {
        waitScrollClick(selectable, 15);
        return new SelectablePage();
    }

    public ResizablePage clickResizable() {
        waitScrollClick(resizable, 15);
        return new ResizablePage();
    }

    public DroppablePage clickDroppable() {
        waitScrollClick(droppable, 15);
        return new DroppablePage();
    }

    public DraggablePage clickDraggable() {
        waitScrollClick(dragabble, 15);
        return new DraggablePage();
    }

    private void waitScrollClick(WebElement element, int seconds) {
        fluentWait.pollingUntilVisibilityOfElement(1, seconds, element);
        javaScript.scrollToElement(element);
        element.click();
    }
}
