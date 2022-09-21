package com.pel.elements;

import com.pel.foundation.Base;
import com.pel.foundation.WebDriverPool;
import com.pel.utilities.Constants;
import com.pel.utilities.Screenshot;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@Tags({@Tag("regression"), @Tag("elements"), @Tag("radio_button")})
public class RadioButtonTest extends Base {
    @Tag("361")
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
