package com.pel.alertsFrameWindows;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("alerts_frames_windows"), @Tag("frames")})
public class FramesTest extends Base {
    @Tag("131")
    @Test
    public void framesTest() {
        mainPage()
                .openDemoQA()
                .clickAlertsFrameWindows()
                .clickFrames()
                .goToFrameBig()
                .validateIfElementContainsText("This is a sample page")
                .closeFrameAndGoBackToFramesPage()
                .goToFrameSmall()
                .validateIfElementContainsText("This is a sample page")
                .closeFrameAndGoBackToFramesPage();
    }

}
