package com.pel.pages.elements.textBoxPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(id = "userName")
    private WebElement userNameInput;

    @FindBy(id = "userEmail")
    private WebElement userEmailInput;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "name")
    private WebElement nameResult;

    @FindBy(id = "email")
    private WebElement emailResult;

    @FindBy(xpath = "//p[@id='currentAddress']")
    private WebElement currentAddressResult;

    @FindBy(xpath = "//p[@id='permanentAddress']")
    private WebElement permanentAddressResult;

    public TextBoxPage writeFullName(String fullName) {
        waitScrollType(userNameInput, fullName);
        return new TextBoxPage();
    }

    public TextBoxPage writeEmail(String email) {
        waitScrollType(userEmailInput, email);
        return new TextBoxPage();
    }

    public TextBoxPage writeCurrentAddress(String currentAddress) {
        waitScrollType(currentAddressInput, currentAddress);
        return new TextBoxPage();
    }

    public TextBoxPage writePermanentAddress(String permanentAddress) {
        waitScrollType(permanentAddressInput, permanentAddress);
        return new TextBoxPage();
    }

    private void waitScrollType(WebElement element, String text) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, element);
        javaScript.scrollToElement(element);
        element.sendKeys(text);
    }

    public TextBoxPage clickSubmit() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, submitButton);
        javaScript.scrollToElement(submitButton);
        submitButton.click();
        return new TextBoxPage();
    }

    public TextBoxPage checkIfNameResultContains(String expectedUserName) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_LOW, nameResult);
        check.checkIfElementContainsText(nameResult, expectedUserName);
        return new TextBoxPage();
    }

    public TextBoxPage checkIfEmailResultContains(String expectedUserName) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_LOW, emailResult);
        check.checkIfElementContainsText(emailResult, expectedUserName);
        return new TextBoxPage();
    }

    public TextBoxPage checkIfCurrentAddressResultContains(String expectedUserName) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_LOW, currentAddressResult);
        check.checkIfElementContainsText(currentAddressResult, expectedUserName);
        return new TextBoxPage();
    }

    public TextBoxPage checkIfPermanentAddressResultContains(String expectedUserName) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_LOW, permanentAddressResult);
        check.checkIfElementContainsText(permanentAddressResult, expectedUserName);
        return new TextBoxPage();
    }

}
