package helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotBrowserStack {


    @Attachment(value = "Screenshot", type = "image/png")
    public String attachScreenshotBase64 () {
        try {
            WebDriver driver = WebDriverRunner.getWebDriver();
            String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

            // Если там есть префикс, Allure его может не понять, поэтому чистим
            if (base64.contains(",")) {
                base64 = base64.substring(base64.indexOf(",") + 1);
            }
            // Возвращаем строку (Allure сам декодирует base64 в картинку)
            return base64;
        } catch (Exception e) {
            System.out.println("Screenshot error: " + e.getMessage());
            return "";
        }
    }
}