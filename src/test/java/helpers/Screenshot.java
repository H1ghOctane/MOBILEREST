package helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.util.Base64;

public class Screenshot {

    public void attachScreenshot() {
        try {
            WebDriver driver = WebDriverRunner.getWebDriver();
            String rawBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

            // 1. Убираем префикс data:image/png;base64, если он есть
            if (rawBase64.contains(",")) {
                rawBase64 = rawBase64.substring(rawBase64.indexOf(",") + 1);
            }

            // 2. Убираем все пробелы и переносы строк (это критично!)
            rawBase64 = rawBase64.replaceAll("\\s", "");

            // 3. Декодируем в байты
            byte[] screenshotBytes = Base64.getDecoder().decode(rawBase64);

            // 4. Прикрепляем как файл в Allure
            Allure.addAttachment(
                    "Screenshot",
                    "image/png",
                    new ByteArrayInputStream(screenshotBytes),
                    ".png"
            );
            System.out.println("Screenshot attached! Size: " + screenshotBytes.length + " bytes");

        } catch (Exception e) {
            System.out.println("Screenshot error: " + e.getMessage());
        }
    }
}