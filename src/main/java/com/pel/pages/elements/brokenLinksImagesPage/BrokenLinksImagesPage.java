package com.pel.pages.elements.brokenLinksImagesPage;

import com.pel.foundation.PageObject;
import com.pel.pages.MainPage;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenLinksImagesPage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(xpath = "//p[text()='Valid image']//following-sibling::img[contains(@src, 'Toolsqa.jpg')]")
    private WebElement validImage;

    @FindBy(xpath = "//img[contains(@src, 'Toolsqa_1.jpg')]")
    private WebElement brokenImage;

    @FindBy(xpath = "//a[contains(text(), 'Valid Link')]")
    private WebElement validLink;

    @FindBy(xpath = "//a[contains(text(), 'Broken Link')]")
    private WebElement brokenLink;

    public BrokenLinksImagesPage checkIfValidPhotoNameEquals(String expectedName) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, validImage);
        javaScript.scrollToElement(validImage);
        check.checkIfElementAttributeContainsValue(validImage, "src", expectedName);
        return new BrokenLinksImagesPage();
    }

    public BrokenLinksImagesPage checkIfBrokenPhotoNameEquals(String expectedName) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, brokenImage);
        javaScript.scrollToElement(brokenImage);
        check.checkIfElementAttributeContainsValue(brokenImage, "src", expectedName);
        return new BrokenLinksImagesPage();
    }

    public BrokenLinkPage clickBrokenLink() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, brokenLink);
        javaScript.scrollToElement(brokenLink);
        brokenLink.click();
        return new BrokenLinkPage();
    }

    public MainPage clickValidLink() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, validLink);
        javaScript.scrollToElement(validLink);
        validLink.click();
        return new MainPage();
    }
}
