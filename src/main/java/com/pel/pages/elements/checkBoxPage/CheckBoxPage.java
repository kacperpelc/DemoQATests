package com.pel.pages.elements.checkBoxPage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.Check;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxPage extends PageObject {
    WebDriver driver = WebDriverPool.getWebDriver();
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(xpath = "//span[contains(text(), 'You have selected')]")
    private WebElement preResult;

    @FindBy(className = "text-success")
    private List<WebElement> results;

    @FindBy(xpath = "//button[contains(@class, 'rct-option-expand-all')]")
    private WebElement expandAll;

    @FindBy(xpath = "//button[contains(@class, 'rct-option-collapse-all')]")
    private WebElement collapseAll;

    @FindBy(xpath = "//*[contains(@class, 'rct-icon-check')]//ancestor::label//span[@class='rct-title']")
    private List<WebElement> selectedItems;

    public CheckBoxPage clickExpandAll() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, expandAll);
        expandAll.click();
        return new CheckBoxPage();
    }

    public CheckBoxPage clickCollapseAll() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, collapseAll);
        collapseAll.click();
        return new CheckBoxPage();
    }

    public CheckBoxPage clickItem(String name) {
        By locator = By.xpath(String.format("//span[text()='%s']//parent::label", name));
        fluentWait.pollingUntilVisibilityOfElement(1, 15, locator);
        javaScript.scrollToElement(driver.findElement(locator));
        driver.findElement(locator).click();
        return new CheckBoxPage();
    }

    public CheckBoxPage expand(String name) {
        By locator = By.xpath(String.format("//span[text()='%s']//parent::label//preceding-sibling::button", name));
        fluentWait.pollingUntilVisibilityOfElement(1, 15, locator);
        driver.findElement(locator).click();
        return new CheckBoxPage();
    }

    private List<String> getSelectedItems() {
        List<String> actualResults = new ArrayList<>();
        for (WebElement element : selectedItems) {
            String elementTrimmed = element.getText();
            if (elementTrimmed.contains(" ")) {
                elementTrimmed = elementTrimmed.replace(" ", "");
                elementTrimmed = elementTrimmed.substring(0, 1).toLowerCase() + elementTrimmed.substring(1);
            }
            else
                elementTrimmed = elementTrimmed.toLowerCase();
            if (elementTrimmed.contains("."))
                elementTrimmed = elementTrimmed.substring(0, element.getText().indexOf(".")-1);
            actualResults.add(elementTrimmed);
        }

        return actualResults;
    }

    private List<String> getResults() {
        List<String> actualResults = new ArrayList<>();
        for (WebElement result : results)
            actualResults.add(result.getText());
        return actualResults;
    }

    public CheckBoxPage checkIfResultContainsSelectedItems() {
        fluentWait.pollingUntilVisibilityOfElement(1, 15, preResult);
        check.checkIfListsAreEqual(getSelectedItems(), getResults());
        return new CheckBoxPage();
    }
}
