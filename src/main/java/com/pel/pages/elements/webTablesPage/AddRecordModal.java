package com.pel.pages.elements.webTablesPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddRecordModal extends PageObject {
    FluentWait fluentWait = new FluentWait();

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "userEmail")
    private WebElement userEmailInput;

    @FindBy(id = "age")
    private WebElement ageInput;

    @FindBy(id = "salary")
    private WebElement salaryInput;

    @FindBy(id = "department")
    private WebElement departmentInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public AddRecordModal writeFirstName(String firstName) {
        waitAndSendKeys(firstNameInput, firstName);
        return new AddRecordModal();
    }

    public AddRecordModal writeLastName(String lastName) {
        waitAndSendKeys(lastNameInput, lastName);
        return new AddRecordModal();
    }

    public AddRecordModal writeUserEmail(String userEmail) {
        waitAndSendKeys(userEmailInput, userEmail);
        return new AddRecordModal();
    }

    public AddRecordModal writeAge(int age) {
        waitAndSendKeys(ageInput, String.valueOf(age));
        return new AddRecordModal();
    }

    public AddRecordModal writeSalary(int salary) {
        waitAndSendKeys(salaryInput, String.valueOf(salary));
        return new AddRecordModal();
    }

    public AddRecordModal writeDepartment(String department) {
        waitAndSendKeys(departmentInput, department);
        return new AddRecordModal();
    }

    private void waitAndSendKeys(WebElement element, String keys) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, element);
        element.sendKeys(keys);
    }

    public WebTablesPage clickSubmitButton() {
        fluentWait.sleep(1);
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, submitButton);
        submitButton.click();
        return new WebTablesPage();
    }
}
