package tests.qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void testIssueSearch() {

        SelenideLogger.addListener("allire", new AllureSelenide());
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        sleep(1000);
        $(".header-search-input").submit();

        $(byLinkText("eroshenkoam/allure-example")).click();
        sleep(1000);
        $(byPartialLinkText("Issuess")).click();
        sleep(2000);
        $(withText("#68")).should(exist);
    }
}
