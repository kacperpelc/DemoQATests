package com.pel.interactions;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SelectableTest extends Base {
    @Tag("441")
    @Test
    public void selectableListTest(){
        List<String> listExpected = Arrays.asList("Cras justo odio", "Dapibus ac facilisis in");
        List<String> listExpectedAll = Arrays.asList("Cras justo odio", "Dapibus ac facilisis in", "Morbi leo risus", "Porta ac consectetur ac");
        mainPage()
                .openDemoQA()
                .clickInteractions()
                .clickSelectable()
                .clickListTab()
                .clickElementList("Cras justo odio")
                .clickElementList("Dapibus ac facilisis in")
                .checkIfAllSelectedListEquals(listExpected)
                .clickElementList("Morbi leo risus")
                .clickElementList("Porta ac consectetur ac")
                .checkIfAllSelectedListEquals(listExpectedAll);
    }

    @Tag("442")
    @Test
    public void selectableGridTest(){
        List<String> listExpected = Arrays.asList("One", "Three", "Five", "Seven", "Nine");
        List<String> listExpectedAll = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine");
        mainPage()
                .openDemoQA()
                .clickInteractions()
                .clickSelectable()
                .clickGridTab()
                .clickElementGrid("One")
                .clickElementGrid("Three")
                .clickElementGrid("Five")
                .clickElementGrid("Seven")
                .clickElementGrid("Nine")
                .checkIfAllSelectedGridEquals(listExpected)
                .clickElementGrid("Two")
                .clickElementGrid("Four")
                .clickElementGrid("Six")
                .clickElementGrid("Eight")
                .checkIfAllSelectedGridEquals(listExpectedAll);
    }
}
