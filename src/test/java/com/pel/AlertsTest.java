package com.pel;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Test;

public class AlertsTest extends Base {

    @Test
    public void alertsPageTest1() {
        mainPage()
                .openDemoQA()
                .clickAlertsFrameWindows()
                .clickFrames();
    }
}
