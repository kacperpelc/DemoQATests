package com.pel.widgets;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AccordionTest extends Base {
    @Tag("611")
    @Test
    public void accordionTest() {
        mainPage()
                .openDemoQA()
                .clickWidgets()
                .clickAccordionPage()
                .clickHeader("What is Lorem Ipsum?")
                .checkIfNoParagraphIsVisible()
                .clickHeader("What is Lorem Ipsum?")
                .checkIfParagraphContains("Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
                .clickHeader("Where does it come from?")
                .checkIfParagraphContains("Contrary to popular belief, Lorem Ipsum is not simply random text.")
                .clickHeader("Why do we use it")
                .checkIfParagraphContains("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.");
    }
}
