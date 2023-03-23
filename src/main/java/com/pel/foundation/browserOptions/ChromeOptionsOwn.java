package com.pel.foundation.browserOptions;

import com.pel.utilities.Constants;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeOptionsOwn {
    public static ChromeOptions get() {
        Map<String, Object> preferences = new HashMap<>();
        preferences.put("profile.default_content_settings.popups", 0);
        preferences.put("download.default_directory", Constants.DOWNLOADS_DIR);
        preferences.put("download.directory_upgrade", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preferences);
        return options;
    }
}
