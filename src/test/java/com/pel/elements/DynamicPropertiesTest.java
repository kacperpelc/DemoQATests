package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("elements"), @Tag("dynamic_properties")})
public class DynamicPropertiesTest extends Base {
    @Tag("341")
    @DisplayName("Dynamic properties test")
    @Test
    public void dynamicPropertiesTest() {
        mainPage()
                .openDemoQA()
                .clickElements()
                .clickDynamicProperties()
                .checkIfEnabledAfterButtonIsEnabled()
                .checkIfElementChangedColor("rgba(220, 53, 69, 1)")
                .checkIfVisibleAfterButtonIsVisible();
    }
}
