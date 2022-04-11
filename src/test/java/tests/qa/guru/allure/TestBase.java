package tests.qa.guru.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    public static final String repository = "GrigoriyAmelin/lesson7-allure";
    public static final String tabName = "Issues";
    public static final String tabSearchText = "is:issue is:open ";

    @BeforeEach
    public void precondition() {
        Configuration.browserSize = "1920x1088";
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
