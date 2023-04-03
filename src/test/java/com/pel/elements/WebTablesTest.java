package com.pel.elements;

import com.pel.foundation.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("regression"), @Tag("elements"), @Tag("web_tables")})
public class WebTablesTest extends Base {
    @Tag("391")
    @DisplayName("Web table test - add new row")
    @Test
    public void webTablesTest1() {
        String firstName = "Durand";
        String lastName = "Jones";
        int age = 50;
        String userEmail = "dj@djati.com";
        int salary = 3000;
        String department = "Indications";

        mainPage()
                .openDemoQA()
                .clickElements()
                .clickWebTables()
                .clickAddButton()
                .writeFirstName(firstName)
                .writeLastName(lastName)
                .writeAge(age)
                .writeUserEmail(userEmail)
                .writeSalary(salary)
                .writeDepartment(department)
                .clickSubmitButton();
    }

    @Tag("392")
    @Test
    public void webTablesTest2() {
        mainPage()
                .openDemoQA()
                .clickElements()
                .clickWebTables();
    }
}
