package tests.qa.guru.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void precondition() {
        Configuration.browserSize = "1920x1088";
    }

    @AfterAll
    static void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
