package com.pel.foundation;

import com.pel.pages.MainPage;
import org.junit.jupiter.api.AfterAll;

public class Base {
    public MainPage mainPage() {
        return new MainPage();
    }

    @AfterAll
    public static void quit() {
        WebDriverPool.getWebDriver().quit();
    }
}
