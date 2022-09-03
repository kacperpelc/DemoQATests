package com.pel.elements.alertsFrameWindows;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class NestedFramesTest extends Base {
    @Tag("151")
    @Test
    public void nestedFramesTest() {
        mainPage()
                .openDemoQA()
                .clickAlertsFrameWindows()
                .clickNestedFrames()
                .goToFrameBig()
                .validateIfElementBodyContainsText("Parent frame")
                .goToInnerFrame()
                .validateIfElementBodyContainsText("Child Iframe")
                .goToOuterFrame()
                .validateIfElementBodyContainsText("Parent frame")
                .closeFrameAndGoBackToNestedFramesPage();
    }
}
