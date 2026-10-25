package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import helpers.Browserstack;
import helpers.Screenshot;
import helpers.ScreenshotBrowserStack;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.util.Base64;

import static com.codeborne.selenide.Selenide.open;
import static config.ConfigManager.BS_CONFIG;
import static io.restassured.RestAssured.given;

public class TestBaseUltra {
    @BeforeAll
    public static void beforeAll() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = -1; // отключаем page load timeout
        Configuration.screenshots = false; // отключаем автоматические скриншоты
        Configuration.savePageSource = false; // отключаем сохранение page source
    }

    @BeforeEach
    public void initTestData() {
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
            System.out.println("Session ID: " + sessionId);

            // 1. Прикрепляем скриншот (вызываем через экземпляр класса Screenshot)
            ///    new ScreenshotBrowserStack().attachScreenshotBase64();
            new Screenshot().attachScreenshot();
            // 2. Закрываем драйвер, чтобы сессия завершилась на BrowserStack
            Selenide.closeWebDriver();

            // --- ВИДЕО ---


            try {
                Thread.sleep(30000);
            } catch (InterruptedException ignored) {
            }

            try {
                String videoUrl = Browserstack.videoUrl(sessionId);
                byte[] video = given()
                        .auth().basic(BS_CONFIG.username(), BS_CONFIG.accessKey())
                        .get(videoUrl)
                        .then().statusCode(200)
                        .extract().asByteArray();
                Allure.addAttachment("Video", "video/mp4",
                        new ByteArrayInputStream(video), ".mp4");
            } catch (Exception e) {
                System.out.println("Video failed: " + e.getMessage());
            }
        }
    }
}