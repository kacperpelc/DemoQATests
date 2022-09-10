package com.pel.utilities;

import com.pel.foundation.WebDriverPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mouse {
    private final WebDriver driver = WebDriverPool.get();

    public void doubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }

    public void dragAndDrop(WebElement source, int xOffset, int yOffset) {  // x+ right, y+ down
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(source, xOffset, yOffset).build().perform();
    }
}
