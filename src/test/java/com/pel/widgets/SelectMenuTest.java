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
                .clickMultiselectDropDownMenu()
                .selectFromMultiselectDropDownMenu("Green")
                .selectFromMultiselectDropDownMenu("Black")
                .checkIfMultiselectFromMenuContains("Green")
                .checkIfMultiselectFromMenuContains("Black")
                .selectFromMultiselectDropDownMenu("Blue")
                .selectFromMultiselectDropDownMenu("Red")
                .checkIfMultiselectFromMenuContains("Blue")
                .checkIfMultiselectFromMenuContains("Red")
                .clickStandardMultiSelectOption("Volvo")
                .clickStandardMultiSelectOption("Opel")
                .checkIfMultiSelectOptionIsSelected("Volvo")
                .checkIfMultiSelectOptionIsSelected("Opel");
    }
}
