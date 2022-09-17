package com.pel.pages.forms;

import com.pel.foundation.PageObject;
import com.pel.pages.forms.practiceForm.PracticeForm;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends PageObject {
    FluentWait fluentWait = new FluentWait();

    @FindBy(xpath = "//span[contains(text(), 'Practice Form')]//parent::li")
    private WebElement practiceForm;

    public PracticeForm clickPracticeForm() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, practiceForm);
        practiceForm.click();
        return new PracticeForm();
    }
}
