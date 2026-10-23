import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
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
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)      // отключаем скриншоты в Allure
                .savePageSource(false)   // отключаем сохранение page source
        );
        open();
    }


    @AfterEach
    void addAttachments() {
        if (!Selenide.webdriver().driver().hasWebDriverStarted()) {
            return;
        }

    }
}