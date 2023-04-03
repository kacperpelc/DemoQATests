package com.pel.alertsFrameWindows;

import com.pel.foundation.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("alerts_frames_windows"), @Tag("alerts")})
public class AlertsTest extends Base {

    @Tag("111")
    @DisplayName("Alerts test")
    @Test
    public void alertsTest() {
        mainPage()
                .openDemoQA()
                .clickAlertsFrameWindows()
                .clickAlerts()
                .clickToSeeAlert()
                .checkIfAlertTextEquals("You clicked a button")
                .acceptAlert()
                .clickToSeeAlertAfter5Seconds()
                .checkIfAlertTextEquals("This alert appeared after 5 seconds")
                .acceptAlert()
                .clickToSeeConfirmBox()
                .checkIfAlertTextEquals("Do you confirm action?")
                .acceptAlert()
                .checkIfMessageAfterConfirmBoxEquals("You selected Ok")
                .clickToSeeConfirmBox()
                .dismissAlert()
                .checkIfMessageAfterConfirmBoxEquals("You selected Cancel")
                .clickToSeePromptBox()
                .checkIfAlertTextEquals("Please enter your name")
                .sendKeysAlert("Kacper")
                .acceptAlert()
                .checkIfMessageAfterPromptBoxEquals("You entered Kacper");
    }
}
