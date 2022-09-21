package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("elements"), @Tag("upload_and_download")})
public class UploadAndDownloadTest extends Base {
    @Tag("381")
    @Test
    public void downloadTest() {
        mainPage()
                .openDemoQA()
                .clickElements()
                .clickUploadAndDownload()   //todo make it working
                .clickDownloadButton();
    }

    @Tag("382")
    @Test
    public void uploadAndDownloadTest() {
        String fileName = "ExamplePNGFile.png";
        mainPage()
                .openDemoQA()
                .clickElements()
                .clickUploadAndDownload()
                .sendFile(fileName)
                .checkIfTextIsVisible(fileName);
    }
}
