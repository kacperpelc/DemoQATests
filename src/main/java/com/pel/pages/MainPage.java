package com.pel.pages;

import com.pel.foundation.PageObject;
import com.pel.foundation.WebDriverPool;
import com.pel.pages.alertsFrameWindows.AlertsFrameWindowsPage;
import com.pel.pages.bookStoreApplication.BookStorePage;
import com.pel.pages.elements.ElementsPage;
import com.pel.pages.forms.FormsPage;
import com.pel.pages.interactions.InteractionsPage;
import com.pel.pages.widgets.WidgetsPage;
import com.pel.utilities.JavaScript;
import com.pel.utilities.FluentWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {
    private final String URL = "https://demoqa.com/";

    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();



    @FindBy(xpath = "//h5[contains(text(), 'Elements')]//ancestor::div[contains(@class, 'top-card')]")
    private WebElement elements;

    @FindBy(xpath = "//h5[contains(text(), 'Forms')]//ancestor::div[contains(@class, 'top-card')]")
    private WebElement forms;

    @FindBy(xpath = "//h5[contains(text(), 'Alerts, Frame & Windows')]//ancestor::div[contains(@class, 'top-card')]")
    private WebElement alertsFrameWindows;

    @FindBy(xpath = "//h5[contains(text(), 'Widgets')]//ancestor::div[contains(@class, 'top-card')]")
    private WebElement widgets;

    @FindBy(xpath = "//h5[contains(text(), 'Interactions')]//ancestor::div[contains(@class, 'top-card')]")
    private WebElement interactions;

    @FindBy(xpath = "//h5[contains(text(), 'Book Store Application')]//ancestor::div[contains(@class, 'top-card')]")
    private WebElement bookStore;

    public MainPage openDemoQA() {
        WebDriverPool.getWebDriver("chrome").get(URL);
        return new MainPage();
    }

    public ElementsPage clickElements() {
        waitScrollClick(elements, 15);
        return new ElementsPage();
    }

    public FormsPage clickForms() {
        waitScrollClick(forms, 15);
        return new FormsPage();
    }

    public AlertsFrameWindowsPage clickAlertsFrameWindows() {
        waitScrollClick(alertsFrameWindows, 15);
        return new AlertsFrameWindowsPage();
    }

    public WidgetsPage clickWidgets() {
        waitScrollClick(widgets, 15);
        return new WidgetsPage();
    }

    public InteractionsPage clickInteractions() {
        waitScrollClick(interactions, 15);
        return new InteractionsPage();
    }

    public BookStorePage clickBookStore() {
        waitScrollClick(bookStore, 15);
        return new BookStorePage();
    }

    private void waitScrollClick(WebElement element, int seconds) {
        fluentWait.pollingUntilVisibilityOfElement(1, seconds, element);
        javaScript.scrollToElement(element);
        element.click();
    }
}
