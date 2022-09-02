package com.pel.utilities;

import com.pel.foundation.WebDriverPool;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class NewWait {
    private final WebDriver driver = WebDriverPool.getWebDriver();

    FluentWait wait;

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ignore) {
        }
    }

    public void sleepMilliseconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ignore) {
        }
    }

    public void pollingUntilVisibilityOfElement(int seconds, int timeout, WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void pollingUntilVisibilityOfElement(int seconds, int timeout, By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(WebDriverPool.getWebDriver().findElement(locator)));
    }

    public void pollingUntilInvisibilityOfElement(int seconds, int timeout, WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void pollingUntilInvisibilityOfElement(int seconds, int timeout, By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(WebDriverPool.getWebDriver().findElement(locator)));
    }

    public void pollingUntilInvisibilityOfElementWithText(int seconds, int timeout, By locator, String text) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }

    public void pollingUntilElementBeingClickable(int seconds, int timeout, WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void pollingUntilElementBeingClickable(int seconds, int timeout, By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(WebDriverPool.getWebDriver().findElement(locator)));
    }

    public void pollingUntilVisibilityOfAlert(int seconds, int timeout) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
