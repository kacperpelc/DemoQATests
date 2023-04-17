package com.pel.widgets;

import com.pel.foundation.Base;
import com.pel.foundation.OptionsCollector;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

@Tags({@Tag("regression"), @Tag("widgets"), @Tag("toolTips")})

public class ToolTipsTest extends Base {
    private boolean checkIfHeadless() {
        return !OptionsCollector.getHeadless().isEmpty();
    }

    @Tag("671")
    @DisabledIf("checkIfHeadless")
    @DisplayName("Tool tips test")
    @Test
    public void toolTipsTest() {
        mainPage()
                .openDemoQA()
                .clickWidgets()
                .clickToolTipsPage()
                .hoverOnButton()
                .checkIfButtonAriaContains("You hovered over the Button")
                .hoverOnInput()
                .checkIfInputAriaContains("You hovered over the text field")
                .hoverOnLink("Contrary")
                .checkIfLinkAriaContains("Contrary", "You hovered over the Contrary")
                .hoverOnLink("1.10.32")
                .checkIfLinkAriaContains("1.10.32", "You hovered over the 1.10.32");
    }
}