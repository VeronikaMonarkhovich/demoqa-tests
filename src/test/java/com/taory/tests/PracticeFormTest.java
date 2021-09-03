package com.taory.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    @Test
    void fillFormTest() {
        String firstName = "Jack";
        String lastName = "Jackson";
        String userEmail = "jack@oo.com";
        String userNumber = "1234567890";
        String month = "September";
        String year = "1990";
        String  subjects = "Physics";
        String currentAddress = "Street";
        String state = "NCR";
        String city = "Delhi";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--023").click();
        $("#subjectsContainer").find("input").setValue(subjects).pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath("test.png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").find("input").setValue(state).pressEnter();
        $("#city").find("input").setValue(city ).pressEnter();
        $("#submit").scrollTo().click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']/following-sibling::td").shouldHave(text("Jack Jackson"));
        $x("//td[text()='Student Email']/following-sibling::td").shouldHave(text("jack@oo.com"));
        $x("//td[text()='Gender']/following-sibling::td").shouldHave(text("Male"));
        $x("//td[text()='Mobile']/following-sibling::td").shouldHave(text("1234567890"));
        $x("//td[text()='Date of Birth']/following-sibling::td").shouldHave(text("23 September,1990"));
        $x("//td[text()='Subjects']/following-sibling::td").shouldHave(text("Physics"));
        $x("//td[text()='Hobbies']/following-sibling::td").shouldHave(text("Reading"));
        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text("test.png"));
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text("Street"));
        $x("//td[text()='State and City']/following-sibling::td").shouldHave(text("NCR Delhi"));
    }
}
