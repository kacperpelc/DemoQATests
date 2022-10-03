package com.pel.pages.widgets.selectMenuPage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

public class SelectMenuPage extends PageObject {
    private final WebDriver driver = WebDriverPool.get();

    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(id = "withOptGroup")
    private WebElement selectValueMenu;

    @FindBy(id = "selectOne")
    private WebElement selectOneMenu;

    @FindBy(id = "oldSelectMenu")
    private WebElement oldSelectMenu;

    @FindBy(xpath = "//*[contains(text(), 'Multiselect drop down')]//ancestor::div[1]//div")
    private WebElement multiselectDropDownMenu;

    @FindBy(id = "cars")
    private WebElement standardMultiSelectMenu;

    public SelectMenuPage clickSelectValueMenu() {
        waitScrollClick(selectValueMenu);
        return new SelectMenuPage();
    }

    public SelectMenuPage clickSelectOneMenu() {
        waitScrollClick(selectOneMenu);
        return new SelectMenuPage();
    }

    public SelectMenuPage clickOldStyleSelectMenu() {
        waitScrollClick(oldSelectMenu);
        return new SelectMenuPage();
    }

    public SelectMenuPage clickMultiselectDropDownMenu() {
        waitScrollClick(multiselectDropDownMenu);
        return new SelectMenuPage();
    }

    public SelectMenuPage selectFromMultiselectDropDownMenu(String text) {
        By selectXpath = By.xpath(String.format("//div[contains(@id, 'react-select') and contains(text(), '%s')]", text));
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_LOW, selectXpath);
        driver.findElement(selectXpath).click();
        return new SelectMenuPage();
    }

    public SelectMenuPage checkIfMultiselectFromMenuContains(String text) {
        By optionXpath = By.xpath("//*[contains(text(), 'Multiselect drop down')]//ancestor::div[1]//div[contains(@style, 'overflow: hidden')]");
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_LOW, optionXpath);
        By optionWithTextXpath = By.xpath(String.format("//*[contains(text(), 'Multiselect drop down')]//ancestor::div[1]//div[contains(text(), '%s')]", text));
        check.checkIfElementContainsText(driver.findElement(optionWithTextXpath), text);
        return new SelectMenuPage();
    }

    public SelectMenuPage clickStandardMultiSelectOption(String text) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, standardMultiSelectMenu);
        javaScript.scrollToElement(standardMultiSelectMenu);
        By optionXpath = By.xpath(String.format("//select[@id='cars']//option[contains(text(), '%s')]", text));
        driver.findElement(optionXpath).click();
        return new SelectMenuPage();
    }

    public SelectMenuPage checkIfMultiSelectOptionIsSelected(String text) {
        By optionXpath = By.xpath(String.format("//select[@id='cars']//option[contains(text(), '%s')]", text));
        if(!driver.findElement(optionXpath).isSelected())
            throw new NoSuchElementException(String.format("Expected: %s should be selected, but it's not selected", driver.findElement(optionXpath).getText()));
        return new SelectMenuPage();
    }

    private void waitScrollClick(WebElement element) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, element);
        javaScript.scrollToElement(element);
        element.click();
    }
}
