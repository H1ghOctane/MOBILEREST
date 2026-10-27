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

public class IosSafariDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(
            @NonNull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        Map<String, Object> bstackOptions = new HashMap<>();

        bstackOptions.put("userName", BS_CONFIG.username());
        bstackOptions.put("accessKey", BS_CONFIG.accessKey());
        bstackOptions.put("deviceName", BS_CONFIG.iosDeviceName());
        bstackOptions.put("osVersion", BS_CONFIG.iosVersion());
        bstackOptions.put("projectName", "Wikipedia Mobile Web");
        bstackOptions.put("buildName", "ios-safari-build");
        bstackOptions.put("sessionName", "safari-wikipedia");
        bstackOptions.put("debug", true);
        bstackOptions.put("networkLogs", true);

        caps.setCapability("browserName", "Safari");
        caps.setCapability("bstack:options", bstackOptions);

        System.out.println("====== IOS SAFARI DRIVER ======");
        System.out.println("Device: " + BS_CONFIG.iosDeviceName());
        System.out.println("Version: " + BS_CONFIG.iosVersion());

        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}