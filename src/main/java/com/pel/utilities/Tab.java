package com.pel.utilities;

import com.pel.foundation.WebDriverPool;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tab {
    private final WebDriver driver = WebDriverPool.getWebDriver();
    private JavaScript javaScript = new JavaScript();

    private final HashMap<Integer, String> tabs = new HashMap<>();
    private static int tabCount = 1;

    public void switchToTab(int tabNumberCountedSinceOne) {
        getWindowTabs();
        driver.switchTo().window(tabs.get(tabNumberCountedSinceOne));
    }

    public void closeTab() {
        driver.close();
    }

    private HashMap<Integer, String> getWindowTabs() {
        List<String> all = new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i < all.size(); i++) {
            tabs.put(i + 1, all.get(i));
        }
        return tabs;
    }
}
