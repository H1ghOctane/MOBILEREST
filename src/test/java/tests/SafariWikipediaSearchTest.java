package tests;

import com.codeborne.selenide.Configuration;
import drivers.IosSafariDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SafariWikipediaSearchTest extends TestBase {

    @BeforeEach
    void setupSafari() {

        Configuration.browser =
                IosSafariDriver.class.getName();

        open("https://en.wikipedia.org/wiki/Appium");
    }

    @Test
    void openWikipediaArticleTest() {

        $("body")
                .shouldHave(text("Appium"));
    }
}