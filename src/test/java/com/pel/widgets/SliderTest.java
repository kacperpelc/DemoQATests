package com.pel.widgets;

import com.pel.foundation.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("widgets"), @Tag("slider")})

public class SliderTest extends Base {
    @Tag("641")
    @DisplayName("Slider test")
    @Test
    public void sliderTest() {
        mainPage()
                .openDemoQAWithoutDecoration()
                .clickWidgets()
                .clickSliderPage()
                .dragAndDropSlider(400)
                .checkIfSliderValueEquals(100)
                .dragAndDropSlider(-400)
                .checkIfSliderValueEquals(0);
    }
}
