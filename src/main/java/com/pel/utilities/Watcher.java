package com.pel.utilities;

import com.pel.foundation.OptionsCollector;
import com.pel.foundation.WebDriverPool;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class Watcher implements TestWatcher {
    private final static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    private final static String dateTimeNow = dateTimeFormat.format(new Date());

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        quit();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        takeScreenshot("successful - " + context.getDisplayName());
        quit();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshot("failed - " + context.getDisplayName());
        quit();
    }

    private void takeScreenshot(String name) {
        Screenshot screenshot = new Screenshot();
        screenshot.captureScreenshot(dateTimeNow, name);
    }

    private void quit() {
        try {
            if(OptionsCollector.getClose().equals("true"))
                WebDriverPool.get().quit();
        } catch (NullPointerException nullPointerException) {
        }
    }
}
