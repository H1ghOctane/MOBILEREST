package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {

        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = -1;
        Configuration.screenshots = false;
        Configuration.savePageSource = false;

    }

    @BeforeEach
    void beforeEach() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterEach
    void addAttachments() {

        if (!Selenide.webdriver().driver().hasWebDriverStarted()) {
            return;
        }
        String sessionId = Selenide.sessionId().toString();
        AllureAttachments.attachScreenshot();
        boolean safariTest = getClass().getSimpleName().contains("Safari");
        Selenide.closeWebDriver();

        if (!safariTest) {
            AllureAttachments.attachVideo(sessionId);
        }
    }
}