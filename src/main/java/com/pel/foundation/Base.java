package com.pel.foundation;

import com.pel.pages.MainPage;
import com.pel.utilities.Watcher;
import org.junit.jupiter.api.extension.RegisterExtension;


public class Base {
    @RegisterExtension
    Watcher watcher = new Watcher();

    public MainPage mainPage() {
        return new MainPage();
    }
}
