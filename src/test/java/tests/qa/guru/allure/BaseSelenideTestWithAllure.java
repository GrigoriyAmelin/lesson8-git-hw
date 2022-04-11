package tests.qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BaseSelenideTestWithAllure extends TestBase {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        // Открыть страницу https://github.com
        open("https://github.com");

        // Найти поле поиска
        $(".header-search-input").click();

        // Найти поле поиска и ввести "GrigoriyAmelin/lesson7-allure"
        $(".header-search-input").sendKeys(repository);

        // Нажать клавишу ввода
        $(".header-search-input").submit();

        // Найти ссылку на репозиторий "GrigoriyAmelin/lesson7-allure" и нажать на нее
        $(byLinkText(repository)).click();

        // Найти таб с названием "Issues" и нажать на него
        $(byPartialLinkText(tabName)).click();

        // Проверить что открыта страница "Issues" и в поле поиска на странице отображается текст "is:issue is:open "
        $("#js-issues-search").shouldHave(exactValue(tabSearchText));

        // Проверить, что название таба соответствует тексту "Issues"
        $("#issues-tab").shouldHave(exactTextCaseSensitive(tabName));
    }
}
