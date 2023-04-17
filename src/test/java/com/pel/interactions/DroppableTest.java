package com.pel.interactions;

import com.pel.foundation.Base;
import com.pel.foundation.OptionsCollector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

@Tags({@Tag("regression"), @Tag("interactions"), @Tag("resizable")})
public class DroppableTest extends Base {
    private boolean checkIfHeadless() {
        return !OptionsCollector.getHeadless().isEmpty();
    }

    @Tag("421")
    @DisabledIf("checkIfHeadless")  // headless mode gives false negative results
    @DisplayName("Droppable test - simple")
    @Test
    public void droppableTest() {
        mainPage()
                .openDemoQA()  // works only without red border around found WebElement
                .clickInteractions()
                .clickDroppable()
                .clickOnSimpleTab()
                .dragAndDropBox()
                .checkIfDroppableBoxColorEquals("rgba(70, 130, 180, 1)");
    }

    @Tag("422")
    @DisabledIf("checkIfHeadless")  // headless mode gives false negative results
    @DisplayName("Droppable test - accept")
    @Test
    public void droppableTest2() {
        mainPage()
                .openDemoQA()
                .clickInteractions()
                .clickDroppable()
                .clickOnAcceptTab()
                .dragAndDropNotAcceptableBox()
                .checkIfBoxIsDroppedCorrectly("rgba(0, 0, 0, 0)")
                .dragAndDropAcceptableBox()
                .checkIfBoxIsDroppedCorrectly("rgba(70, 130, 180, 1)");
    }

    @Tag("423")
    @DisabledIf("checkIfHeadless")  // headless mode gives false negative results
    @DisplayName("Droppable test - prevent propagation")
    @Test
    public void droppableTest3() {
        mainPage()
                .openDemoQA()
                .clickInteractions()
                .clickDroppable()
                .clickOnPreventPropagationTab()
                .dragAndDropBox("not greedy")
                .checkIfBoxIsDroppedCorrectly("not greedy", "outer", "rgba(70, 130, 180, 1)")
                .checkIfBoxIsDroppedCorrectly("not greedy", "inner", "rgba(70, 130, 180, 1)")
                .dragAndDropBox("greedy")
                .checkIfBoxIsDroppedCorrectly("greedy", "outer", "rgba(0, 0, 0, 0)")
                .checkIfBoxIsDroppedCorrectly("greedy", "inner", "rgba(70, 130, 180, 1)");
    }

    @Tag("424")
    @DisabledIf("checkIfHeadless")  // headless mode gives false negative results
    @DisplayName("Droppable test - prevent propagation")
    @Test
    public void droppableTest4() {
        mainPage()
                .openDemoQAWithoutDecoration()
                .clickInteractions()
                .clickDroppable()
                .clickOnRevertDraggableTab()
                .dragAndDropRevertableBox()
                .checkIfBoxIsDroppedCorrectly("rgba(70, 130, 180, 1)")
                .checkIfDropBoxCameToBase()
                .dragAndDropNotRevertableBox()
                .checkIfBoxIsDroppedCorrectly("rgba(70, 130, 180, 1)")
                .checkIfDropBoxStayedInDroppable();
    }
}
