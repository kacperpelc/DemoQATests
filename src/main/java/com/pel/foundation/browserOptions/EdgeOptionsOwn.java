package com.pel.foundation.browserOptions;

import com.pel.utilities.Constants;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;

public class EdgeOptionsOwn {
    private static final boolean headless = System.getProperty("browser.headless").equalsIgnoreCase("true");

    public static EdgeOptions get() {
        Map<String, Object> preferences = new HashMap<>();
        preferences.put("profile.default_content_settings.popups", 0);
        preferences.put("download.default_directory", Constants.DOWNLOADS_DIR);
        preferences.put("download.directory_upgrade", true);

        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("prefs", preferences);
        options.setHeadless(headless);
        return options;
    }
}
