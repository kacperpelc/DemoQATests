package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DynamicPropertiesTest extends Base {
    @Tag("341")
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
