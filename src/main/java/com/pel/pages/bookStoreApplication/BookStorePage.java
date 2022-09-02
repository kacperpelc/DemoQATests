package com.pel.pages.bookStoreApplication;

import com.pel.foundation.PageObject;
import com.pel.utilities.JavaScript;
import com.pel.utilities.NewWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookStorePage extends PageObject {
    NewWait newWait = new NewWait(/*WebDriverPool.getWebDriver()*/);
    JavaScript javaScript = new JavaScript();

    @FindBy(xpath = "//input[@id='searchBox']")
    private WebElement searchBox;

    @FindBy (xpath = "//div[@class='rt-tr-group']//div[@class='action-buttons']//a")
    private List<WebElement> listOfBooks;

    /*public BookStorePage assertion() {
     *//*if (5 > 2)
            throw new RuntimeException();
        String.format("Expected: %s, actual %s", "drzewo", "golonka");
        return new BookStorePage();*//*
    }*/

    public BookStorePage searchBook(String title){
        newWait.pollingUntilVisibilityOfElement(1, 15, searchBox);
        searchBox.sendKeys(title);
        // TODO Asercja na title w titlu przy uzyciu listOfBooks
        newWait.sleep(5);
        return new BookStorePage();
    }

    public BookStorePage checkFindings(String title){
        for (WebElement element: listOfBooks) {
            if (!element.getText().contains(title)){
                throw new NoSuchElementException(String.format("Expected '%s' in '%s'",title, element.getText()));
            }
        }
        return new BookStorePage();
    }

    //TODO 1 - Wejście na strone logowania
    //TODO 2 - Dodawanie książki do profilu


}



