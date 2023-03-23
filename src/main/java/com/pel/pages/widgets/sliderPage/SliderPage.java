package com.pel.pages.widgets.sliderPage;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends PageObject {
    private final WebDriver driver = WebDriverPool.get();

    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    Mouse mouse = new Mouse();

    @FindBy(xpath = "//input[@type='range']")
    private WebElement slider;

    @FindBy(xpath = "//input[@id='sliderValue']")
    private WebElement sliderValue;

    public SliderPage dragAndDropSlider(int x) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, slider);
        mouse.dragAndDrop(slider, x, 0);
        return new SliderPage();
    }

    public SliderPage checkIfSliderValueEquals(int expectedValue) {
        check.checkIfElementAttributeContainsValue(sliderValue, "value", String.valueOf(expectedValue));
        return new SliderPage();
    }
}
