package com.pel.pages.elements.uploadAndDownloadPage;

import com.pel.foundation.PageObject;
import com.pel.utilities.Check;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadAndDownloadPage extends PageObject {
    Check check = new Check();
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(id = "downloadButton")
    private WebElement buttonDownload;

    @FindBy(id = "uploadFile")
    private WebElement buttonUpload;

    @FindBy(id = "uploadedFilePath")
    private WebElement uploadedText;

    public UploadAndDownloadPage clickDownloadButton() {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, buttonDownload);
        javaScript.scrollToElement(buttonDownload);
        buttonDownload.click();
        return new UploadAndDownloadPage();
    }

    public UploadAndDownloadPage sendFile(String fileName) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, buttonUpload);
        javaScript.scrollToElement(buttonUpload);
        buttonUpload.sendKeys(Constants.ATTACHMENTS_DIR_BACKSLASH + fileName);
        fluentWait.sleep(5);
        return new UploadAndDownloadPage();
    }

    public UploadAndDownloadPage checkIfTextIsVisible(String expectedText) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, uploadedText);
        check.checkIfElementEqualsText(uploadedText, "C:\\fakepath\\" + expectedText);
        return new UploadAndDownloadPage();
    }
}
