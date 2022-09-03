package com.pel.elements.alertsFrameWindows;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ModalDialogsTest extends Base {
    @Tag("141")
    @Test
    public void modalDialogsTest() {
        mainPage()
                .openDemoQA()
                .clickAlertsFrameWindows()
                .clickModalDialogs()
                .clickSmallModalButton()
                .checkIfHeaderContainsText("Small Modal")
                .closeModalXButton()
                .clickSmallModalButton()
                .checkIfBodyContainsText("This is a small modal. It has very less content")
                .closeModalCloseButton()
                .clickLargeModalButton()
                .checkIfHeaderContainsText("Large Modal")
                .closeModalXButton()
                .clickLargeModalButton()
                .checkIfBodyContainsText("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
    }
}
