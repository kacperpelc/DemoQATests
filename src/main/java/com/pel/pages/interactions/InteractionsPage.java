package com.pel.pages.interactions;

import com.pel.foundation.PageObject;
import com.pel.pages.elements.brokenLinksImagesPage.BrokenLinksImagesPage;
import com.pel.pages.elements.buttonsPage.ButtonsPage;
import com.pel.pages.elements.checkBoxPage.CheckBoxPage;
import com.pel.pages.elements.dynamicPropertiesPage.DynamicPropertiesPage;
import com.pel.pages.elements.linksPage.LinksPage;
import com.pel.pages.elements.radioButtonPage.RadioButtonPage;
import com.pel.pages.elements.textBoxPage.TextBoxPage;
import com.pel.pages.elements.uploadAndDownloadPage.UploadAndDownloadPage;
import com.pel.pages.elements.webTablesPage.WebTablesPage;
import com.pel.pages.interactions.dragabble.DraggablePage;
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

    public DroppablePage clickDroppablePage() {
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
