package com.pel.forms;

import com.pel.foundation.Base;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("forms"), @Tag("practice_form")})
public class PracticeFormTest extends Base {
    @Tag("411")
    @Test
    public void practiceFormTest() {
        mainPage()
                .openDemoQA()
                .clickForms()
                .clickPracticeForm()
                .writeFirstName("Kacper")
                .writeLastName("Pelc")
                .writeUserEmail("kacperpelc@mail.com")
                .selectGender("Male")
                .writeMobileNumber("0661234642")
                .clickOnDateInput()
                .clickPreviousMonth()
                .clickNextMonth()
                .selectMonthFromList("May")
                .selectYearFromList(1993)
                .selectDay(29)
                .selectHobby("Sports")
                .selectHobby("Reading")
                .selectHobby("Music")
                //.selectPicture("")
                .writeCurrentAddress("Szczecin")
                /*.clickSelectState()     // element is hidden behind advertisement
                .selectStateFromList("NCR")*/
                .clickSubmitButton();
    }
}
