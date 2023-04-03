package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.*;

@Tags({@Tag("regression"), @Tag("elements"), @Tag("upload_and_download")})
public class UploadAndDownloadTest extends Base {
    @Disabled
    @Tag("381")
    @DisplayName("Download test")
    @Test
    public void downloadTest() {
        mainPage()
                .openDemoQA()
                .clickElements()
                .clickUploadAndDownload()   //todo make it working
                .clickDownloadButton();
    }

    @Tag("382")
    @DisplayName("Upload test")
    @Test
    public void uploadTest() {
        String fileName = "ExamplePNGFile.png";
        mainPage()
                .openDemoQA()
                .clickElements()
                .clickUploadAndDownload()
                .sendFile(fileName)
                .checkIfTextIsVisible(fileName);
    }
}
