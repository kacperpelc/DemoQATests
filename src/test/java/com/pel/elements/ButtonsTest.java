package com.pel.elements;

import com.pel.foundation.Base;
import com.pel.utilities.JavaScript;
import com.pel.utilities.FluentWait;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ButtonsTest extends Base {
    JavaScript javaScript = new JavaScript();
    FluentWait fluentWait = new FluentWait();

    @Tag("321")
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
