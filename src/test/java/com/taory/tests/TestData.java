package com.taory.tests;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
        static Faker faker = new Faker(new Locale("en"));
        public static String firstName = faker.name().firstName();
        public static String lastName = faker.name().lastName();
        public static String userEmail = faker.internet().emailAddress();
        public static String userNumber = faker.number().digits(10);
        public static String subjects = "Physics";
        public static String currentAddress = faker.address().streetAddress();
        public static String state = "NCR";
        public static String city = "Delhi";
        public static String day = "15";
        public static String month = "August";
        public static String year = "1990";
}
