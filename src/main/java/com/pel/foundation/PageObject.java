package com.pel.foundation;

import org.openqa.selenium.support.PageFactory;

public class PageObject extends WebDriverPool {
    public PageObject() {
        PageFactory.initElements(driverDecorated, this);
    }
}