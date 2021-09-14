package com.taory.tests;

import com.taory.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.taory.tests.TestData.*;

public class PracticeFormTest extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillFormTest() {
        practiceFormPage.openPage();
        practiceFormPage.typeFirstName(firstName);
        practiceFormPage.typeLastName(lastName);
        practiceFormPage.typeUserEmail(userEmail);
        $("[for=gender-radio-1]").click();
        practiceFormPage.typeUserNumber(userNumber);
        practiceFormPage.calendar.setDate(day,month,year);
        $("#subjectsContainer").find("input").setValue(subjects).pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath("test.png");
        practiceFormPage.typeCurrentAddress(currentAddress);
        $("#state").find("input").setValue(state).pressEnter();
        $("#city").find("input").setValue(city).pressEnter();
        $("#submit").scrollTo().click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        practiceFormPage.checkResultsValue("Student Name",firstName + " " + lastName);
        practiceFormPage.checkResultsValue("Student Email",userEmail);
        practiceFormPage.checkResultsValue("Gender","Male");
        practiceFormPage.checkResultsValue("Mobile",userNumber);
        practiceFormPage.checkResultsValue("Date of Birth",day + " " + month + "," + year);
        practiceFormPage.checkResultsValue("Subjects",subjects);
        practiceFormPage.checkResultsValue("Hobbies","Reading");
        practiceFormPage.checkResultsValue("Picture","test.png");
        practiceFormPage.checkResultsValue("Address",currentAddress);
        practiceFormPage.checkResultsValue("State and City",state + " " + city);

    }
}
