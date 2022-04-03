package tests.qa.guru.allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").click();
        sleep(1000);
        $(".header-search-input").submit();
    }

    @Step("Открываем репозиторий {repository}")
    public void openRepository(String repository) {
        $(byLinkText(repository)).click();
        sleep(1000);
    }

    @Step("Переходим в таб Issues")
    public void openIssueTab() {
        $(byPartialLinkText("Issues")).click();
        sleep(2000);
    }

    @Step("Проверяем, что существует Issue с номером {number}")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(exist);
    }
}
