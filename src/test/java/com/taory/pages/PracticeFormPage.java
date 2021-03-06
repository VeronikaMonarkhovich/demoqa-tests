package com.taory.pages;

import com.codeborne.selenide.SelenideElement;
import com.taory.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private SelenideElement formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress");

    private final String FORM_TITLE = "Student Registration Form";

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void typeUserEmail(String value) {
        userEmailInput.setValue(value);
    }

    public void selectGender(String value) {
        $(String.format("input[value = %s]", value)).sibling(0).click();
    }

    public void typeSubject(String value) {
        $("#subjectsContainer").find("input").setValue(value).pressEnter();
    }

    public void selectHobbies(String value) {
        $x(String.format("//*[contains(@for, 'hobbies-checkbox') and .='%s']", value)).click();
    }

    public void uploadFile(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
    }

    public void typeUserNumber(String value) {
        userNumberInput.setValue(value);
    }

    public void typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
    }

    public void selectState(String value) {
        $("#state").find("input").setValue(value).pressEnter();
    }

    public void selectCity(String value) {
        $("#city").find("input").setValue(value).pressEnter();
    }

    public void clickSubmit() {
        $("#submit").scrollTo().click();
    }

    public void checkResultsText(String value) {
        $(".modal-content").shouldHave(text(value));
    }

    public void checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']/following-sibling::td").shouldHave(text(value));
    }
}