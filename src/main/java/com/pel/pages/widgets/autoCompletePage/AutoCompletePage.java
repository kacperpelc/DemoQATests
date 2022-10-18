package com.pel.pages.widgets.autoCompletePage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoCompletePage extends PageObject {
    private final WebDriver driver = WebDriverPool.get();

    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(xpath = "//*[@id = 'autoCompleteMultipleInput']")
    private WebElement multipleColorsInput;

    @FindBy(xpath = "//div[@id='autoCompleteMultipleContainer']//div[contains(@class, 'auto-complete__value-container')]")
    private WebElement multipleColorsResults;

    @FindBy(id = "autoCompleteSingleContainer")
    private WebElement singleColorInput;

    public AutoCompletePage writeInMultipleColorsInput(String text) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, multipleColorsInput);
        javaScript.scrollToElement(multipleColorsInput);
        multipleColorsInput.click();
        multipleColorsInput.sendKeys(text);
        return new AutoCompletePage();
    }

    public AutoCompletePage selectColor(String color) {
        fluentWait.sleep(1);
        By chosenColorXpath = By.xpath(String.format("//*[contains(text(), '%s')]", color));
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM, chosenColorXpath);
        driver.findElement(chosenColorXpath).click();
        return new AutoCompletePage();
    }

    public AutoCompletePage checkIfMultipleColorsContains(String expectedText) {
        check.checkIfElementContainsText(multipleColorsResults, expectedText);
        return new AutoCompletePage();
    }
}
