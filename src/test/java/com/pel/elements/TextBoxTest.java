package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends Base {
    @Tag("371")
    @Test
    public void textBoxTest() {
        String name = "Kacper";
        String email = "kacperpelc@mail.com";
        String currentAddress = "Szczecin";
        String permanentAddress = "Memphis";

        mainPage()
                .openDemoQA()
                .clickElements()
                .clickTextBox()
                .writeFullName(name)
                .writeEmail(email)
                .writeCurrentAddress(currentAddress)
                .writePermanentAddress(permanentAddress)
                .clickSubmit()
                .checkIfNameResultContains(name)
                .checkIfEmailResultContains(email)
                .checkIfCurrentAddressResultContains(currentAddress)
                .checkIfPermanentAddressResultContains(permanentAddress);
    }
}
