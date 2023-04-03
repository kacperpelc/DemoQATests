package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("elements"), @Tag("radio_button")})
public class RadioButtonTest extends Base {
    @Tag("361")
    @DisplayName("Radio button test")
    @Test
    public void radioButtonTest() {
        mainPage()
                .openDemoQA()
                .clickElements()
                .clickRadioButton()
                .clickRadioButtonYes()
                .checkIfRadioMessageEquals("You have selected Yes")
                .clickRadioButtonImpressive()
                .checkIfRadioMessageEquals("You have selected Impressive")
                .clickRadioButtonNo()
                .checkIfRadioButtonNoIsDisabled();
    }
}
