package com.pel.foundation;

import com.pel.pages.MainPage;
import com.pel.utilities.Screenshot;
import org.junit.jupiter.api.AfterEach;

public class Base {
    public MainPage mainPage() {
        return new MainPage();
    }

    @AfterEach
    public void quit() {
        Screenshot screenshot = new Screenshot();
        screenshot.captureScreenshot("atTestEnd");

        try {
            if(OptionsCollector.getClose().equals("true"))
                WebDriverPool.get().quit();
        } catch (NullPointerException nullPointerException) {
        }
    }
}
