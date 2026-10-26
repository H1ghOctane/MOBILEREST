package tests;

import com.codeborne.selenide.Configuration;
import drivers.AndroidBrowserstackDriver;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class SearchAndroidTest extends TestBase {

    @BeforeEach
    void setupAndroid() {

        Configuration.browser =
                AndroidBrowserstackDriver.class.getName();

        open();
    }

    @Test
    void successfulSearchTest() {

        step("Открыть поиск и ввести запрос", () -> {

            $(AppiumBy.accessibilityId("Search Wikipedia"))
                    .click(tap());

            $(id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("Dinosaur");
        });

        step("Проверить, что результаты поиска найдены", () ->

                $$(className("android.widget.TextView"))
                        .shouldHave(sizeGreaterThan(0))
        );

        step("Открыть статью про динозавров", () ->

                $(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .click(tap())
        );

        step("Проверить, что статья открылась", () ->

                $(id("org.wikipedia.alpha:id/view_page_title_text"))
                        .shouldBe(visible)
        );
    }
}