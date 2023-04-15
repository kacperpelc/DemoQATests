package com.pel.foundation;

import com.pel.pages.MainPage;
import com.pel.utilities.Watcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;


public class Base {
    @BeforeAll
    public static void setHttp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
    }

    @RegisterExtension
    Watcher watcher = new Watcher();

    @AfterAll
    public static void quit() {
        try {
            if(OptionsCollector.getClose().equals("true"))
                WebDriverPool.get().quit();
        } catch (NullPointerException nullPointerException) {
        }
    }

    public MainPage mainPage() {
        return new MainPage();
    }
}
