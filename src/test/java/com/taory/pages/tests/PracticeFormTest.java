package com.taory.pages.tests;

import com.github.javafaker.Faker;
import com.taory.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;
import java.util.Locale;

import static io.qameta.allure.Allure.step;

public class PracticeFormTest {
    Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.number().digits(10);
    String subjects = "Physics";
    String currentAddress = faker.address().streetAddress();
    String state = "NCR";
    String city = "Delhi";
    String day = "15";
    String month = "August";
    String year = "1990";
    String gender = "Male";
    String hobby = "Reading";
    String file = "test.png";
    String text = "Thanks for submitting the form";

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillFormTest() {
        step("Открываем главную страницу", () -> {
            practiceFormPage.openPage();
        });

        step("Вводим данные студента", () -> {
            practiceFormPage.typeFirstName(firstName);
            practiceFormPage.typeLastName(lastName);
            practiceFormPage.typeUserEmail(userEmail);
            practiceFormPage.selectGender(gender);
            practiceFormPage.typeUserNumber(userNumber);
        });

        step("Выбираем дату рождения", () -> {
            practiceFormPage.calendar.setDate(day, month, year);
        });

        step("Выбираем предметы и хобби", () -> {
            practiceFormPage.typeSubject(subjects);
            practiceFormPage.selectHobbies(hobby);
        });

        step("Загружаем файл", () -> {
            practiceFormPage.uploadFile(file);
        });

        step("Вводим адрес", () -> {
            practiceFormPage.typeCurrentAddress(currentAddress);
            practiceFormPage.selectState(state);
            practiceFormPage.selectCity(city);
        });

        step("Нажимаем Submit", () -> {
            practiceFormPage.clickSubmit();
        });

        step("Проверяем результаты", () -> {
            practiceFormPage.checkResultsText(text);
            practiceFormPage.checkResultsValue("Student Name", firstName + " " + lastName);
            practiceFormPage.checkResultsValue("Student Email", userEmail);
            practiceFormPage.checkResultsValue("Gender", gender);
            practiceFormPage.checkResultsValue("Mobile", userNumber);
            practiceFormPage.checkResultsValue("Date of Birth", day + " " + month + "," + year);
            practiceFormPage.checkResultsValue("Subjects", subjects);
            practiceFormPage.checkResultsValue("Hobbies", hobby);
            practiceFormPage.checkResultsValue("Picture", file);
            practiceFormPage.checkResultsValue("Address", currentAddress);
            practiceFormPage.checkResultsValue("State and City", state + " " + city);
        });
    }
}