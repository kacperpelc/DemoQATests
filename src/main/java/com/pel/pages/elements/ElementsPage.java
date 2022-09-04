package com.pel.pages.elements;

import com.pel.foundation.PageObject;
import com.pel.pages.elements.brokenLinksImagesPage.BrokenLinksImagesPage;
import com.pel.pages.elements.buttonsPage.ButtonsPage;
import com.pel.pages.elements.checkBoxPage.CheckBoxPage;
import com.pel.pages.elements.dynamicPropertiesPage.DynamicPropertiesPage;
import com.pel.pages.elements.linksPage.LinksPage;
import com.pel.pages.elements.radioButtonPage.RadioButtonPage;
import com.pel.pages.elements.textBoxPage.TextBoxPage;
import com.pel.pages.elements.uploadAndDownloadPage.UploadAndDownloadPage;
import com.pel.pages.elements.webTablesPage.WebTablesPage;
import com.pel.utilities.JavaScript;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends PageObject {
    JavaScript javaScript = new JavaScript();
    FluentWait fluentWait = new FluentWait();

    @FindBy(xpath = "//span[contains(text(), 'Text Box')]//parent::li")
    private WebElement textBox;

    @FindBy(xpath = "//span[contains(text(), 'Check Box')]//parent::li")
    private WebElement checkBox;

    @FindBy(xpath = "//span[contains(text(), 'Radio Button')]//parent::li")
    private WebElement radioButton;

    @FindBy(xpath = "//span[contains(text(), 'Web Tables')]//parent::li")
    private WebElement webTables;

    @FindBy(xpath = "//span[contains(text(), 'Buttons')]//parent::li")
    private WebElement buttons;

    @FindBy(xpath = "//span[contains(text(), 'Links')]//parent::li")
    private WebElement links;

    @FindBy(xpath = "//span[contains(text(), 'Broken Links - Images')]//parent::li")
    private WebElement brokenLinksImages;

    @FindBy(xpath = "//span[contains(text(), 'Upload and Download')]//parent::li")
    private WebElement uploadAndDownload;

    @FindBy(xpath = "//span[contains(text(), 'Dynamic Properties')]//parent::li")
    private WebElement dynamicProperties;


    public TextBoxPage clickTextBox() {
        waitScrollClick(textBox, 15);
        return new TextBoxPage();
    }

    public CheckBoxPage clickCheckBox() {
        waitScrollClick(checkBox, 15);
        return new CheckBoxPage();
    }

    public RadioButtonPage clickRadioButton() {
        waitScrollClick(radioButton, 15);
        return new RadioButtonPage();
    }

    public WebTablesPage clickWebTables() {
        waitScrollClick(webTables, 15);
        return new WebTablesPage();
    }

    public ButtonsPage clickButtons() {
        waitScrollClick(buttons, 15);
        return new ButtonsPage();
    }

    public LinksPage clickLinks() {
        waitScrollClick(links, 15);
        return new LinksPage();
    }

    public BrokenLinksImagesPage clickBrokenLinksImages() {
        waitScrollClick(brokenLinksImages, 15);
        return new BrokenLinksImagesPage();
    }

    public UploadAndDownloadPage clickUploadAndDownload() {
        waitScrollClick(uploadAndDownload, 15);
        return new UploadAndDownloadPage();
    }

    public DynamicPropertiesPage clickDynamicProperties() {
        waitScrollClick(dynamicProperties, 15);
        return new DynamicPropertiesPage();
    }

    private void waitScrollClick(WebElement element, int seconds) {
        fluentWait.pollingUntilVisibilityOfElement(1, seconds, element);
        javaScript.scrollToElement(element);
        element.click();
    }
}
