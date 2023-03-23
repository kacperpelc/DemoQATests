package com.pel.widgets;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("widgets"), @Tag("toolTips")})

public class ToolTipsTest extends Base {
    @Tag("671")
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