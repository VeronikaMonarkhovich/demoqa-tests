package com.taory.pages.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.taory.pages.config.CredentialsConfig;
import com.taory.pages.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        CredentialsConfig credentials =
                ConfigFactory.create(CredentialsConfig.class);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.remote = "https://" + credentials.login() + ":" + credentials.password() + "@" + System.getProperty("remoteUrl");
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}