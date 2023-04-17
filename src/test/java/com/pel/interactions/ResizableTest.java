package com.pel.interactions;

import com.pel.foundation.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

@Tags({@Tag("regression"), @Tag("interactions"), @Tag("resizable")})
public class ResizableTest extends Base {
    @Tag("431")
    @DisabledIf("checkIfHeadless")  // headless mode gives false negative results
    @DisplayName("Resizable test")
    @Test
    public void resizableTest() {
        mainPage()
                .openDemoQAWithoutDecoration()  // works only without red border around found WebElement
                .clickInteractions()
                .clickResizable()
                .checkIfElementContainsText("Resizable box, starting at 200x200")
                .checkIfElementsDimensionsEquals(200, 200)
                .dragAndDrop(50, 50)
                .checkIfElementsDimensionsEquals(250, 250)
                .dragAndDrop(-100, -100)
                .checkIfElementsDimensionsEquals(150, 150)
                .dragAndDrop(350, 150)
                .checkIfElementsDimensionsEquals(500, 300);
    }

    @Tag("432")
    @DisabledIf("checkIfHeadless")  // headless mode gives false negative results
    @DisplayName("Resizable no limit test")
    @Test
    public void resizableNoLimitTest() {
        mainPage()
                .openDemoQAWithoutDecoration()
                .clickInteractions()
                .clickResizable()
                .checkIfElementNoLimitEqualsText("Resizable")
                .checkIfElementsNoLimitDimensionsEquals(200, 200)
                .dragAndDropNoLimit(50, 0)
                .checkIfElementsNoLimitDimensionsEquals(250, 200)
                .dragAndDropNoLimit(-50, 0)
                .checkIfElementsNoLimitDimensionsEquals(200, 200)
                .dragAndDropNoLimit(0, 50)
                .checkIfElementsNoLimitDimensionsEquals(200, 250)
                .dragAndDropNoLimit(0, -50)
                .checkIfElementsNoLimitDimensionsEquals(200, 200)
                .dragAndDropNoLimit(-180, -180)
                .checkIfElementsNoLimitDimensionsEquals(20, 20);
    }
}
