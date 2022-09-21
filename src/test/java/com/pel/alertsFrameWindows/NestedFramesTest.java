package com.pel.alertsFrameWindows;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("alerts_frames_windows"), @Tag("nested_frames")})
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
