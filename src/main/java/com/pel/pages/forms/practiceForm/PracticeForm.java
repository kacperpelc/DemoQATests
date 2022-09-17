package com.pel.pages.forms.practiceForm;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.pages.MainPage;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeForm extends PageObject {
    private final WebDriver driver = WebDriverPool.get();
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "userEmail")
    private WebElement userEmailInput;

    @FindBy(id = "userNumber")
    private WebElement mobileInput;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthInput;

    @FindBy(xpath = "//div[contains(@class, 'subjects-auto-complete__value-container')]")
    private WebElement subjectsInput;

    @FindBy(xpath = "//label[@class='custom-control-label' and contains(text(), 'Sports')]")
    private WebElement sportsCheckBox;

    @FindBy(xpath = "//label[@class='custom-control-label' and contains(text(), 'Reading')]")
    private WebElement readingCheckBox;

    @FindBy(xpath = "//label[@class='custom-control-label' and contains(text(), 'Music')]")
    private WebElement musicCheckBox;

    @FindBy(id = "uploadPicture")
    private WebElement uploadInput;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public PracticeForm writeFirstName(String firstName) {
        waitScrollSendKeys(firstNameInput, firstName);
        return new PracticeForm();
    }

    public PracticeForm writeLastName(String lastName) {
        waitScrollSendKeys(lastNameInput, lastName);
        return new PracticeForm();
    }

    public PracticeForm writeUserEmail(String userEmail) {
        waitScrollSendKeys(userEmailInput, userEmail);
        return new PracticeForm();
    }

    public PracticeForm selectGender(String gender) {
        WebElement genderRadioButton = driver.findElement(By.xpath(String.format("//label[@class='custom-control-label' and contains(text(), '%s')]", gender)));
        genderRadioButton.click();
        return new PracticeForm();
    }

    public PracticeForm writeMobileNumber(String number) {
        waitScrollSendKeys(mobileInput, number);
        return new PracticeForm();
    }

    public Calendar clickOnDateInput() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, dateOfBirthInput);
        javaScript.scrollToElement(dateOfBirthInput);
        dateOfBirthInput.click();
        String calendarTitleXpath = "//div[contains(@class, 'react-datepicker__current-month')]";
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_LOW, By.xpath(calendarTitleXpath));
        javaScript.scrollToElement(driver.findElement(By.xpath(calendarTitleXpath)));
        return new Calendar();
    }

    public PracticeForm clickSubmitButton() {
        javaScript.scrollToElement(submitButton);
        submitButton.submit();
        fluentWait.sleep(5);
        return new PracticeForm();
    }

    private void waitScrollSendKeys(WebElement element, String keys) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, element);
        javaScript.scrollToElement(element);
        element.sendKeys(keys);
    }
}
