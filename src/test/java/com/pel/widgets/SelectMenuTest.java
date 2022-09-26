package com.pel.widgets;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SelectMenuTest extends Base {
    @Tag("661")
    @Test
    public void selectMenuTest() {
        mainPage()
                .openDemoQA()
                .clickWidgets()
                .clickSelectMenuPage()
                .clickStandardMultiSelectOption("Volvo")
                .checkIfMultiSelectOptionIsSelected("Volvo");
    }
}
