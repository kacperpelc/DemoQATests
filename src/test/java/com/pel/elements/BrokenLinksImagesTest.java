package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("elements"), @Tag("broken_links_images")})
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
