package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import static config.ConfigManager.BS_CONFIG;

public class IosBrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", BS_CONFIG.username());
        bstackOptions.put("accessKey", BS_CONFIG.accessKey());
        bstackOptions.put("projectName", "First Java Project");
        bstackOptions.put("buildName", "browserstack-build-1");
        bstackOptions.put("sessionName", "first_test");

        caps.setCapability("bstack:options", bstackOptions);
        caps.setCapability("platformName", "android");
        caps.setCapability("appium:deviceName", BS_CONFIG.iosDeviceName());
        caps.setCapability("appium:platformVersion", BS_CONFIG.iosVersion());
        caps.setCapability("appium:app", BS_CONFIG.iosAppUrl());

        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}