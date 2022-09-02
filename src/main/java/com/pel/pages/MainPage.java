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
import com.pel.utilities.NewWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {
    private final String URL = "https://demoqa.com/";

    NewWait newWait = new NewWait();
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
        newWait.pollingUntilVisibilityOfElement(1, 15, elements);
        javaScript.scrollToElement(elements);
        elements.click();
        return new ElementsPage();
    }

    public FormsPage clickForms() {
        newWait.pollingUntilVisibilityOfElement(1, 15, forms);
        javaScript.scrollToElement(forms);
        forms.click();
        return new FormsPage();
    }

    public AlertsFrameWindowsPage clickAlertsFrameWindows() {
        newWait.pollingUntilVisibilityOfElement(1, 15, alertsFrameWindows);
        javaScript.scrollToElement(alertsFrameWindows);
        alertsFrameWindows.click();
        return new AlertsFrameWindowsPage();
    }

    public WidgetsPage clickWidgets() {
        newWait.pollingUntilVisibilityOfElement(1, 15, widgets);
        javaScript.scrollToElement(widgets);
        widgets.click();
        return new WidgetsPage();
    }

    public InteractionsPage clickInteractions() {
        newWait.pollingUntilVisibilityOfElement(1, 15, bookStore);
        javaScript.scrollToElement(bookStore);
        bookStore.click();
        return new InteractionsPage();
    }

    public BookStorePage clickBookStore() {
        newWait.pollingUntilVisibilityOfElement(1, 15, bookStore);
        javaScript.scrollToElement(bookStore);
        bookStore.click();
        return new BookStorePage();
    }
}
