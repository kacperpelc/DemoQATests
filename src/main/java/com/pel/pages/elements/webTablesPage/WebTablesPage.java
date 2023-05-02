package com.pel.pages.elements.webTablesPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablesPage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(id = "addNewRecordButton")
    private WebElement addButton;

    @FindBy(id = "searchBox")
    private WebElement searchInput;

    @FindBy(xpath = "//div[contains(@class, 'header') and contains(text(), 'First Name')]")
    private WebElement firstNameFilter;

    @FindBy(xpath = "//div[contains(@class, 'header') and contains(text(), 'Last Name')]")
    private WebElement lastNameFilter;

    @FindBy(xpath = "//div[contains(@class, 'header') and contains(text(), 'Age')]")
    private WebElement ageFilter;

    @FindBy(xpath = "//div[contains(@class, 'header') and contains(text(), 'Email')]")
    private WebElement emailFilter;

    @FindBy(xpath = "//div[contains(@class, 'header') and contains(text(), 'Salary')]")
    private WebElement salaryFilter;

    @FindBy(xpath = "//div[contains(@class, 'header') and contains(text(), 'Department')]")
    private WebElement departmentFilter;

    @FindBy(xpath = "//div[contains(@class, 'header') and contains(text(), 'Action')]")
    private WebElement actionFilter;

    public AddRecordModal clickAddButton() {
        fluentWait.sleep(1);
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, addButton);
        addButton.click();
        return new AddRecordModal();
    }

    private void findByFirstName(String firstName) {
        String xpath = "//div[@role='gridcell'][1]";
    }


}
