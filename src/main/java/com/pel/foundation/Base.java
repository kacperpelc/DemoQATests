package com.pel.foundation;

import com.pel.pages.MainPage;
import com.pel.utilities.Constants;
import com.pel.utilities.Screenshot;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.RegisterExtension;

public class Base {
    public MainPage mainPage() {
        return new MainPage();
    }

    @RegisterExtension
    Screenshot watcher = new Screenshot(WebDriverPool.getWebDriver(), Constants.SCREENSHOTS);


    @AfterAll
    public static void quit() {
        WebDriverPool.getWebDriver().quit();
    }
}
