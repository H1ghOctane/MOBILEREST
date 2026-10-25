package tests;


import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static io.qameta.allure.Allure.step;

@Tag("ios")
public class SearchIphoneTest extends TestBase {
    @Test

    void successfulOpenWikipediaTest() {
        String platform = System.getProperty("platform", "android");
        step("Click search button", () ->
                $(AppiumBy.accessibilityId("Search Wikipedia")).click(tap()));
        step("Type in search field", () -> {
            if (platform.equals("ios")) {
                $(AppiumBy.className("XCUIElementTypeSearchField")).sendKeys("Appium");
            } else {
                $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
            }
        });
    }
}