package com.pel.foundation;

import com.pel.foundation.browserOptions.ChromeOptionsOwn;
import com.pel.foundation.browserOptions.EdgeOptionsOwn;
import com.pel.utilities.EventCapture;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebDriverPool {
    static WebDriver driver;
    static WebDriver driverDecorated;

    public static WebDriver getWebDriver() {
        switch(OptionsCollector.getBrowserName().toLowerCase()) {
            case "chrome":
                driver = getChromeDriver();
                break;
            case "firefox":
                driver = getFirefoxDriver();
                break;
            case "edge":
                driver = getEdgeDriver();
                break;
            default:
                throw new NoSuchElementException("Wrong WebDriver name");
        }
        driverDecorated = driver;
        driverDecorated.manage().window().maximize();
        return driverDecorated;
    }

    public static WebDriver getWebDriverDecorated() {
        getWebDriver();
        WebDriverListener listener = new EventCapture();
        driverDecorated = new EventFiringDecorator(listener).decorate(driver);
        BasicConfigurator.configure();
        driverDecorated.manage().window().maximize();
        return driverDecorated;
    }

    public static WebDriver get() {
        return driverDecorated;
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(ChromeOptionsOwn.get());
    }

    private static WebDriver getFirefoxDriver() {    // TODO make it work
        WebDriverManager.firefoxdriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        return new FirefoxDriver();
    }

    private static WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(EdgeOptionsOwn.get());
    }
}

