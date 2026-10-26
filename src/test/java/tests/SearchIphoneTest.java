package tests;

import com.codeborne.selenide.Configuration;
import drivers.IosBrowserstackDriver;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static io.qameta.allure.Allure.step;

@Tag("ios")
public class SearchIphoneTest extends TestBase {

    @BeforeEach
    void setupIos() {

        Configuration.browser =
                IosBrowserstackDriver.class.getName();

        open();
    }

    @Test
    void successfulOpenWikipediaTest() {

        step("Click search button", () ->
                $(AppiumBy.accessibilityId("Search Wikipedia")).click(tap()));

        step("Type search text", () ->
                $(AppiumBy.className("XCUIElementTypeSearchField")).sendKeys("Appium")
        );
    }
}