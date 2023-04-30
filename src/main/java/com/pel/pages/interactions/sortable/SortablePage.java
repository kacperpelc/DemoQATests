package com.pel.pages.interactions.sortable;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SortablePage extends PageObject {
    private final WebDriver driver = WebDriverPool.get();
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();
    Mouse mouse = new Mouse();

    @FindBy(id = "demo-tab-list")
    private WebElement listTab;

    @FindBy(id = "demo-tab-grid")
    private WebElement gridTab;

    @FindBy(xpath = "//div[@id='demo-tabpane-list']//div[contains(@class, 'list-group-item')]")
    private List<WebElement> elementsList;
    @FindBy(xpath = "//div[@id='demo-tabpane-grid']//div[contains(@class, 'list-group-item')]")
    private List<WebElement> elementsGrid;

    public SortablePage clickListTab() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, listTab);
        javaScript.scrollToElement(listTab);
        listTab.click();
        return new SortablePage();
    }

    public SortablePage clickGridTab() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, gridTab);
        javaScript.scrollToElement(gridTab);
        gridTab.click();
        return new SortablePage();
    }

    private WebElement getElementOfList(String name) {
        String xpath = String.format("//div[@id='demo-tabpane-list']//div[contains(@class, 'list-group-item') and contains(text(), '%s')]", name);
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, By.xpath(xpath));
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement getElementOfGrid(String name) {
        String xpath = String.format("//div[@id='demo-tabpane-grid']//div[contains(@class, 'list-group-item') and contains(text(), '%s')]", name);
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, By.xpath(xpath));
        return driver.findElement(By.xpath(xpath));
    }

    private List<String> getList(List<WebElement> list) {
        List<String> listActual = new ArrayList<>();
        for (WebElement element : list) {
            listActual.add(element.getText());
        }
        return listActual;
    }

    public SortablePage dragAndDropList(String source, String target) {
        mouse.dragAndDrop(getElementOfList(source), getElementOfList(target));
        return new SortablePage();
    }

    public SortablePage dragAndDropGrid(String source, String target) {
        mouse.dragAndDrop(getElementOfGrid(source), getElementOfGrid(target));
        return new SortablePage();
    }

    public SortablePage checkIfListEquals(List<String> listExcepted) {
        fluentWait.sleep(1);
        check.checkIfListsAreEqual(getList(elementsList), listExcepted);
        return new SortablePage();
    }

    public SortablePage checkIfGridEquals(List<String> listExcepted) {
        fluentWait.sleep(1);
        check.checkIfListsAreEqual(getList(elementsGrid), listExcepted);
        return new SortablePage();
    }
}
