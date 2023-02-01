package com.pel.utilities;

import com.pel.foundation.OptionsCollector;
import com.pel.foundation.WebDriverPool;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Watcher implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        quit();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        takeScreenshot("successful");
        quit();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshot("failed");
        quit();
    }

    private void takeScreenshot(String name) {
        Screenshot screenshot = new Screenshot();
        screenshot.captureScreenshot(name);
    }

    private void quit() {
        try {
            if(OptionsCollector.getClose().equals("true"))
                WebDriverPool.get().quit();
        } catch (NullPointerException nullPointerException) {
        }
    }
}
