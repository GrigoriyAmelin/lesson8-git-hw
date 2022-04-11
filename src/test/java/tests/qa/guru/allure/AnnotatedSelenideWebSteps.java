package tests.qa.guru.allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.addAttachment;

public class AnnotatedSelenideWebSteps extends TestBase {

    @Step("Открыть страницу https://github.com")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти поле поиска и ввести \"{repository}\"")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
    }

    @Step("Нажать клавишу ввода")
    public void clickSubmit() {
        $(".header-search-input").submit();
    }

    @Step("Найти ссылку на репозиторий \"{repository}\" и нажать на нее")
    public void openRepository(String repository) {
        $(byLinkText(repository)).click();
        addAttachment("Page source", "text/html", WebDriverRunner.source(), "html");
    }

    @Step("Найти таб с названием \"{tabName}\" и нажать на него")
    public void openIssueTab(String tabName) {
        $(byPartialLinkText(tabName)).click();
    }

    @Step("Проверить что открыта страница \"{tabName}\" и в поле поиска на странице отображается " +
            "текст \"{tabSearchText}\"")
    public void shouldExistTabSearchText(String tabSearchText, String tabName) {
        $("#js-issues-search").shouldHave(exactValue(tabSearchText));
    }

    @Step("Проверить, что название таба соответствует тексту \"{tabName}\"")
    public void shouldBeTabName(String tabName) {
        $("#issues-tab").shouldHave(exactTextCaseSensitive(tabName));
        addAttachment("Page source", "text/html", WebDriverRunner.source(), "html");
    }
}
