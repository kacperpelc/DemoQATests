package com.pel.pages.widgets.accordionPage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccordionPage extends PageObject {
    private final WebDriver driver = WebDriverPool.get();

    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(xpath = "//div[@class='collapse show']")
    private WebElement paragraphVisible;

    public AccordionPage clickHeader(String text) {
        By headerXpath = By.xpath(String.format("//div[@class='card']//div[contains(text(), '%s')]", text));
        fluentWait.sleep(1);
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, headerXpath);
        javaScript.scrollToElement(driver.findElement(headerXpath));
        driver.findElement(headerXpath).click();
        return new AccordionPage();
    }

    public AccordionPage checkIfNoParagraphIsVisible() {
        try {
            paragraphVisible.isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return new AccordionPage();
        }
        throw new NoSuchElementException("No paragraph should be visible");
    }

    public AccordionPage checkIfParagraphContains(String expectedText) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_LOW, paragraphVisible);
        javaScript.scrollToElement(paragraphVisible);
        check.checkIfElementContainsText(paragraphVisible, expectedText);
        return new AccordionPage();
    }
}
