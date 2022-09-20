package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BrokenLinksImagesTest extends Base {
    @Tag("311")
    @Test
    public void brokenLinksImagesTest() {
        mainPage()
                .openDemoQA()
                .clickElements()
                .clickBrokenLinksImages()
                .checkIfValidPhotoNameEquals("Toolsqa.jpg")
                .checkIfBrokenPhotoNameEquals("Toolsqa_1.jpg")
                .clickValidLink()
                .clickElements()
                .clickBrokenLinksImages()
                .clickBrokenLink()
                .checkIfTextContains("This page returned a 500 status code.");
    }
}
