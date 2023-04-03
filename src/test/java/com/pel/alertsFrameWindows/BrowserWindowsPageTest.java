package com.pel.alertsFrameWindows;

import com.pel.foundation.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("alerts_frames_windows"), @Tag("browser_windows_page")})
public class BrowserWindowsPageTest extends Base {

    @Tag("121")
    @DisplayName("Browsers and windows test")
    @Test
    public void browserWindowsTest() {
        mainPage()
                .openDemoQA()
                .clickAlertsFrameWindows()
                .clickBrowserWindows()
                .openNewTab()
                .validateIfElementContainsText("This is a sample page")
                .closeTabAndGoBackToBrowserWindowsPage()
                .openNewWindow()
                .validateIfElementContainsText("This is a sample page")
                .closeTabAndGoBackToBrowserWindowsPage()
                /*.openNewWindowWithMessage()
                //TODO make it work
                .validateIfElementWithMessageContainsText("Knowledge increases by sharing but not by saving.")
                .closeTabAndGoBackToBrowserWindowsPage()*/;
    }
}
