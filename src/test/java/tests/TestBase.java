package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import helpers.Browserstack;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = -1; // отключаем page load timeout
        Configuration.screenshots = false; // отключаем автоматические скриншоты
        Configuration.savePageSource = false; // отключаем сохранение page source
    }

    @BeforeEach
    public void initTestData()  {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()// отключаем сохранение page source
        );
        open();
    }


//    @AfterEach
//    void addAttachments() {
//        if (!Selenide.webdriver().driver().hasWebDriverStarted()) {
//
//            String sessionId = Selenide.sessionId().toString();
//            System.out.println(sessionId);
// 5d21b4d41f35c80be39b175a0ea072d363bf1ac5

    @AfterEach
    void addAttachments() {
        if (Selenide.webdriver().driver().hasWebDriverStarted()) {
            String sessionId = Selenide.sessionId().toString();
            System.out.println(sessionId);
            // Получить URL видео и прикрепить к Allure
            String videoUrl = Browserstack.videoUrl(sessionId);
            Allure.addAttachment("Video", "text/plain", videoUrl);
        }
    }
}