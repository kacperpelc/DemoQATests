package com.pel.foundation;

import com.pel.utilities.EventCapture;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebDriverPool {
    static WebDriver driver;
    static WebDriver driverDecorated;

    public static WebDriver getWebDriver(String driverName) {
        switch(driverName.toLowerCase()) {
            case "chrome":
                driver = getChromeDriver();
                break;
            case "firefox":
                driver = getFirefoxDriver();
                break;
            default:
                throw new NoSuchElementException("Wrong WebDriver name");
        }

        WebDriverListener listener = new EventCapture();
        driverDecorated = new EventFiringDecorator(listener).decorate(driver);
        BasicConfigurator.configure();
        driverDecorated.manage().window().maximize();
        return driverDecorated;
    }

    public static WebDriver getWebDriver() {
        return driverDecorated;
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver() {    // TODO make it work
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}

