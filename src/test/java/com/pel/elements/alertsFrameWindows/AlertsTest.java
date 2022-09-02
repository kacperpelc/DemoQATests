package com.pel.elements.alertsFrameWindows;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AlertsTest extends Base {

    @Tag("111")
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
