package com.pel.pages.widgets;

import com.pel.foundation.PageObject;
import com.pel.pages.widgets.accordionPage.AccordionPage;
import com.pel.pages.widgets.autoCompletePage.AutoCompletePage;
import com.pel.pages.widgets.datePickerPage.DatePickerPage;
import com.pel.pages.widgets.menuPage.MenuPage;
import com.pel.pages.widgets.progressBarPage.ProgressBarPage;
import com.pel.pages.widgets.selectMenuPage.SelectMenuPage;
import com.pel.pages.widgets.sliderPage.SliderPage;
import com.pel.pages.widgets.tabsPage.TabsPage;
import com.pel.pages.widgets.toolTipsPage.ToolTipsPage;
import com.pel.utilities.Constants;
import com.pel.utilities.FluentWait;
import com.pel.utilities.JavaScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WidgetsPage extends PageObject {
    FluentWait fluentWait = new FluentWait();
    JavaScript javaScript = new JavaScript();

    @FindBy(xpath = "//span[contains(text(), 'Accordian')]//parent::li")
    private WebElement accordion;

    @FindBy(xpath = "//span[contains(text(), 'Auto Complete')]//parent::li")
    private WebElement autoComplete;

    @FindBy(xpath = "//span[contains(text(), 'Date Picker')]//parent::li")
    private WebElement datePicker;

    @FindBy(xpath = "//span[contains(text(), 'Slider')]//parent::li")
    private WebElement slider;

    @FindBy(xpath = "//span[contains(text(), 'Progress Bar')]//parent::li")
    private WebElement progressBar;

    @FindBy(xpath = "//span[contains(text(), 'Tabs')]//parent::li")
    private WebElement tabs;

    @FindBy(xpath = "//span[contains(text(), 'Tool Tips')]//parent::li")
    private WebElement toolTips;

    @FindBy(xpath = "//span[contains(text(), 'Menu')]//parent::li")
    private WebElement menu;

    @FindBy(xpath = "//span[contains(text(), 'Select Menu')]//parent::li")
    private WebElement selectMenu;

    public AccordionPage clickAccordionPage() {
        waitScrollClick(accordion);
        return new AccordionPage();
    }

    public AutoCompletePage clickAutoCompletePage() {
        waitScrollClick(autoComplete);
        return new AutoCompletePage();
    }

    public DatePickerPage clickDatePickerPage() {
        waitScrollClick(datePicker);
        return new DatePickerPage();
    }

    public SliderPage clickSliderPage() {
        waitScrollClick(slider);
        return new SliderPage();
    }

    public ProgressBarPage clickProgressBarPage() {
        waitScrollClick(progressBar);
        return new ProgressBarPage();
    }

    public TabsPage clickTabsPage() {
        waitScrollClick(tabs);
        return new TabsPage();
    }

    public ToolTipsPage clickToolTipsPage() {
        waitScrollClick(toolTips);
        return new ToolTipsPage();
    }

    public MenuPage clickMenuPage() {
        waitScrollClick(menu);
        return new MenuPage();
    }

    public SelectMenuPage clickSelectMenuPage() {
        waitScrollClick(selectMenu);
        return new SelectMenuPage();
    }

    private void waitScrollClick(WebElement element) {
        fluentWait.pollingUntilVisibilityOfElement(1, Constants.TIMEOUT_MEDIUM_HIGH, element);
        javaScript.scrollToElement(element);
        element.click();
    }
}
