package com.pel.widgets;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("widgets"), @Tag("selectMenu")})

public class SliderTest extends Base {
    @Tag("641")
    @Test
    public void sliderTest() {
        mainPage()
                .openDemoQA()
                .clickWidgets()
                .clickSliderPage()
                .dragAndDropSlider(300)
                .checkIfSliderValueEquals(100)
                .dragAndDropSlider(-300)
                .checkIfSliderValueEquals(0);
    }
}
