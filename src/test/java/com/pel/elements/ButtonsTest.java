package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("elements"), @Tag("buttons")})
public class ButtonsTest extends Base {
    @Tag("321")
    @DisplayName("Buttons test")
    @Test
    public void buttonsTest() {
        mainPage()
                .openDemoQA()
                .clickElements()
                .clickButtons()
                .leftClickOnClickMeButton()
                .checkIfLeftClickMessageEquals("You have done a dynamic click")
                .rightClickOnRightClickMeButton()
                .checkIfRightClickMessageEquals("You have done a right click")
                .doubleClickOnDoubleClickMeButton()
                .checkIfDoubleClickMessageEquals("You have done a double click");
    }
}
