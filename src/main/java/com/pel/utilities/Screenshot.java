package com.pel.utilities;

import com.pel.foundation.WebDriverPool;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Screenshot {
    private WebDriver driver = WebDriverPool.get();

    private void captureScreenshot(WebDriver driver, String root, String fileName) {
        final String path = Constants.SCREENSHOTS + root + File.separator;
        try {
            new File(path).mkdirs();
            try (FileOutputStream out = new FileOutputStream(path + fileName + ".png")) {
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException e) {
            System.out.println("screenshot failed:" + e.getMessage());
        }
    }

    public void captureScreenshot(String root, String fileName) {
        captureScreenshot(driver, root, fileName);
    }
}
