package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("elements"), @Tag("checkbox")})
public class CheckBoxTest extends Base {
    @Tag("231")
    @Test
    public void checkBoxTest() {
        mainPage()
                .openDemoQA()
                .clickElements()
                .clickCheckBox()
                .clickExpandAll()
                .clickItem("Word File.doc")
                .clickItem("Excel File.doc")
                .checkIfResultContainsSelectedItems()
                .clickItem("Documents")
                .checkIfResultContainsSelectedItems()
                .clickItem("Public")
                .clickItem("General")
                .checkIfResultContainsSelectedItems()
                .clickCollapseAll();
    }
}
