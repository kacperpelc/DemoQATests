package com.pel.foundation;

import com.pel.pages.MainPage;
import com.pel.utilities.Watcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;


public class Base {
    @BeforeAll
    public static void setHttp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
    }

    @RegisterExtension
    Watcher watcher = new Watcher();

    public MainPage mainPage() {
        return new MainPage();
    }
}
