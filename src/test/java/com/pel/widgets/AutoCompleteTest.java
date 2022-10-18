package com.pel.widgets;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AutoCompleteTest extends Base {
    @Tag("621")
    @Test
    public void autoCompleteTest() {
        mainPage()
                .openDemoQA()
                .clickWidgets()
                .clickAutoCompletePage()
                .writeInMultipleColorsInput("a")
                .selectColor("Black")
                .checkIfMultipleColorsContains("Black")
                .writeInMultipleColorsInput("a")
                .selectColor("Magenta")
                .checkIfMultipleColorsContains("Magenta")
                .writeInMultipleColorsInput("a")
                .selectColor("Aqua")
                .checkIfMultipleColorsContains("Aqua");
    }
}
