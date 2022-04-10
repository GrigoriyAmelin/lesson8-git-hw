package tests.qa.guru.allure;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Condition.exactValue;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.*;
import static io.qameta.allure.Allure.parameter;

public class LambdaSelenideTest extends TestBase {

    public static final String repository = "GrigoriyAmelin/lesson7-allure";
    public static final String tabName = "Issues";
    public static final String tabSearchText = "is:issue is:open ";

    @Test
    public void testIssueSearchWithLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        parameter("Репозиторий", repository);
        parameter("Таб", tabName);

        step("Открыть страницу https://github.com", () -> open("https://github.com"));

        step("Найти поле поиска и ввести \"GrigoriyAmelin/lesson7-allure\"", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repository);
            sleep(1000);
        });

        step("Нажать клавишу ввода", () -> $(".header-search-input").submit());

        step("Найти ссылку на репозиторий \"GrigoriyAmelin/lesson7-allure\" и нажать на нее", () -> {
            $(byLinkText(repository)).click();
            addAttachment("Page source", "text/html", WebDriverRunner.source(), "html");
            sleep(1000);
        });

        step("Найти таб с названием \"Issues\" и нажать на него", () -> {
            $(byPartialLinkText(tabName)).click();
            sleep(1000);
        });

        step("Проверить что открыта страница \"Issues\" и в поле поиска на странице отображается " +
                "текст \"is:issue is:open \"", () -> {
            $("#js-issues-search").shouldHave(exactValue(tabSearchText));
        });

        step("Проверить, что название таба соответствует тексту \"Issues\"", () -> {
            $("#issues-tab").shouldHave(exactTextCaseSensitive(tabName));
            addAttachment("Page source", "text/html", WebDriverRunner.source(), "html");
            sleep(1000);
        });
    }
}
