package com.pel.elements.alertsFrameWindows;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BrowserWindowsPageTest extends Base {

    @Tag("121")
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
                .openNewWindowWithMessage()
                //TODO make it work
                .validateIfElementWithMessageContainsText("Knowledge increases by sharing but not by saving.")
                .closeTabAndGoBackToBrowserWindowsPage();
    }
}
