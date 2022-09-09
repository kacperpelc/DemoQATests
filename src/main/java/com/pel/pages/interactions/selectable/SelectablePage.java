package com.pel.pages.interactions.selectable;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SelectablePage extends PageObject {
    private final WebDriver driver = WebDriverPool.get();
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();
    Mouse mouse = new Mouse();

    @FindBy(id = "demo-tab-list")
    private WebElement listTab;

    @FindBy(id = "demo-tab-grid")
    private WebElement gridTab;

    @FindBy(xpath = "//div[@id='demo-tabpane-list']//li")
    private List<WebElement> elementsList;
    @FindBy(xpath = "//div[@id='demo-tabpane-grid']//li")
    private List<WebElement> elementsGrid;

    public SelectablePage clickListTab() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, listTab);
        javaScript.scrollToElement(listTab);
        listTab.click();
        return new SelectablePage();
    }

    public SelectablePage clickGridTab() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, gridTab);
        javaScript.scrollToElement(gridTab);
        gridTab.click();
        return new SelectablePage();
    }

    private WebElement getElementOfList(String name) {
        String xpath = String.format("//div[@id='demo-tabpane-list']//li[contains(text(), '%s')]", name);
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, By.xpath(xpath));
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement getElementOfGrid(String name) {
        String xpath = String.format("//div[@id='demo-tabpane-grid']//li[contains(text(), '%s')]", name);
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, By.xpath(xpath));
        return driver.findElement(By.xpath(xpath));
    }

    private List<String> getList(List<WebElement> list) {
        List<String> listActual = new ArrayList<>();
        for (WebElement element : list) {
            if(element.getAttribute("class").contains("active"))
                listActual.add(element.getText());
        }
        return listActual;
    }

    public SelectablePage clickElementList(String element) {
        getElementOfList(element).click();
        return new SelectablePage();
    }

    public SelectablePage clickElementGrid(String element) {
        getElementOfGrid(element).click();
        return new SelectablePage();
    }

    public SelectablePage checkIfAllSelectedListEquals(List<String> listExcepted) {
        check.checkIfListsAreEqual(getList(elementsList), listExcepted);
        return new SelectablePage();
    }

    public SelectablePage checkIfAllSelectedGridEquals(List<String> listExcepted) {
        check.checkIfListsAreEqual(getList(elementsGrid), listExcepted);
        return new SelectablePage();
    }

    public SelectablePage printLists(List<String> listExcepted) {
        for (String element : getList(elementsList)) {
            System.out.println("aaa" + element);
        }
        for (String element : listExcepted) {
            System.out.println("bbb" + element);
        }
        return new SelectablePage();
    }
}
