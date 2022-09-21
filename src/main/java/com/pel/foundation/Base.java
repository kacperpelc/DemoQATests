package com.pel.foundation;

import com.pel.pages.MainPage;
import com.pel.utilities.Constants;
import com.pel.utilities.Screenshot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.RegisterExtension;

public class Base {
    public MainPage mainPage() {
        return new MainPage();
    }

    @RegisterExtension
    Screenshot watcher = new Screenshot(WebDriverPool.get(), Constants.SCREENSHOTS);


    @AfterEach
    public void quit() {
        try {
            if(OptionsCollector.getClose().equals("true"))
                WebDriverPool.get().quit();
        } catch (NullPointerException nullPointerException) {
        }
    }
}
