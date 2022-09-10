package com.pel.foundation;

public class OptionsCollector {
    public static final String BROWSER_NAME = System.getProperty("browser.name", "chrome");

    public static String getBrowserName() {
        if (BROWSER_NAME == null || BROWSER_NAME.isEmpty()) {
            throw new IllegalArgumentException("Property [browser.name] is required! Use System.setProperty(\"browser.name\", \"chrome\") as an example");
        } else {
            return BROWSER_NAME;
        }
    }
}
