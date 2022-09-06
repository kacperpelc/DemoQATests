package com.pel.interactions;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortableTest extends Base {
    @Tag("451")
    @Test
    public void sortableListTest() {
        List<String> listExpectedAscending = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        List<String> listExpectedDescending = Arrays.asList("Six", "Five", "Four", "Three", "Two", "One");
        mainPage()
                .openDemoQA()
                .clickInteractions()
                .clickSortable()
                .clickListTab()
                .checkIfListEquals(listExpectedAscending)
                .dragAndDropList("One", "Six")
                .dragAndDropList("Two", "Six")
                .dragAndDropList("Three", "Six")
                .dragAndDropList("Four", "Six")
                .dragAndDropList("Five", "Six")
                .checkIfListEquals(listExpectedDescending);
    }

    @Tag("452")
    @Test
    public void sortableGridTest() {
        List<String> listExpectedAscending = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine");
        List<String> listExpectedDescending = Arrays.asList("Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One");
        mainPage()
                .openDemoQA()
                .clickInteractions()
                .clickSortable()
                .clickGridTab()
                .checkIfGridsEquals(listExpectedAscending)
                .dragAndDropGrid("One", "Nine")
                .dragAndDropGrid("Two", "Nine")
                .dragAndDropGrid("Three", "Nine")
                .dragAndDropGrid("Four", "Nine")
                .dragAndDropGrid("Five", "Nine")
                .dragAndDropGrid("Six", "Nine")
                .dragAndDropGrid("Seven", "Nine")
                .dragAndDropGrid("Eight", "Nine")
                .checkIfGridsEquals(listExpectedDescending);
    }
}
