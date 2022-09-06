package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LinksTest extends Base {
    @Tag("251")
    @Test
    public void linksTest() {
        mainPage()
                .openDemoQA()
                .clickElements()
                .clickLinks()
                .clickHomeButton()
                .closeTabAndGoBackToLinksPage()
                .clickHomeDynamicButton()
                .closeTabAndGoBackToLinksPage()
                .clickCreatedLinkButton()
                .checkIfResponseContains(201, "Created")
                .clickNoContentButton()
                .checkIfResponseContains(204, "No Content")
                .clickMovedButtonButton()
                .checkIfResponseContains(301, "Moved Permanently")
                .clickBadRequestButton()
                .checkIfResponseContains(400, "Bad Request")
                .clickUnauthorizedButton()
                .checkIfResponseContains(401, "Unauthorized")
                .clickForbiddenButton()
                .checkIfResponseContains(403, "Forbidden")
                .clickInvalidUrlButton()
                .checkIfResponseContains(404, "Not Found");
    }
}
