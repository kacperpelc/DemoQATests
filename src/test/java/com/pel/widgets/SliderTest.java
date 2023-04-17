package com.pel.widgets;

import com.pel.foundation.Base;
import com.pel.foundation.OptionsCollector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

@Tags({@Tag("regression"), @Tag("widgets"), @Tag("slider")})

public class SliderTest extends Base {
    private boolean checkIfHeadless() {
        return !OptionsCollector.getHeadless().isEmpty();
    }

    @Tag("641")
    @DisabledIf("checkIfHeadless")  // headless mode gives false negative results
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
