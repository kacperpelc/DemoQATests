package com.pel.widgets;

import com.pel.foundation.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("widgets"), @Tag("selectMenu")})

public class SelectMenuTest extends Base {
    @Tag("661")
    @DisplayName("Select menu test")
    @Test
    public void selectMenuTest() {
        mainPage()
                .openDemoQA()
                .clickWidgets()
                .clickSelectMenuPage()
                .clickSelectValueMenu()
                .selectFromSelectValueMenu("Group 2, option 1")
                .checkIfSelectValueMenuContains("Group 2, option 1")
                .clickSelectOneMenu()
                .selectFromSelectOneMenu("Prof.")
                .checkIfSelectOneMenuContains("Prof.")
                .clickOldStyleSelectMenu()
                .selectFromOldStyleSelectMenu("Blue")
                .checkIfOldStyleSelectMenuEquals("Blue")
                .clickOldStyleSelectMenu()
                .selectFromOldStyleSelectMenu("Aqua")
                .checkIfOldStyleSelectMenuEquals("Aqua")
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
