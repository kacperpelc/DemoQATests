package com.pel.utilities;

import com.pel.foundation.WebDriverPool;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {
    private WebDriver driver = WebDriverPool.get();
    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    String dateTimeNow = dateTimeFormat.format(new Date());
    private String path = Constants.SCREENSHOTS + dateTimeNow + File.separator;

    public void captureScreenshot(WebDriver driver, String fileName) {
        try {
            new File(path).mkdirs();
            try (FileOutputStream out = new FileOutputStream(path + "screenshot-" + fileName + ".png")) {
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException e) {
            System.out.println("screenshot failed:" + e.getMessage());
        }
    }

    public void captureScreenshot(String fileName) {
        captureScreenshot(driver, fileName);
    }
}
