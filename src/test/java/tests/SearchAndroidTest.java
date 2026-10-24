package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchAndroidTest extends TestBase {

    @Test
        void successfulSearchTest() {
            step("Type search", () -> {
                $(AppiumBy.accessibilityId("Search Wikipedia")).click(tap());
                $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
            });
            step("Verify content found", () ->
                    $$(className("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));
        }
    }