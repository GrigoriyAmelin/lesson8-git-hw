package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @Test
    void softAssertionsPageExist() {
        Configuration.browserSize = "1120x1088";
        open("https://github.com/selenide/selenide");

        // Переход в раздел Wiki проекта
        $("#wiki-tab").click();

        // Проверка наличия страницы SoftAssertions в Pages
        $("#wiki-pages-filter").setValue("soft");
        $(".filter-bar").sibling(0).shouldHave(exactText("SoftAssertions"));

        // Переход на страницу Soft Assertions
        $(".filter-bar").sibling(0).$(byText("SoftAssertions")).click();

        // Проверка наличия примера кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").parent().scrollTo()
                .shouldHave(exactText("3. Using JUnit5 extend test class:"));

        // Добавлено ожидание на странице для удобного просмотра результатов
        sleep(1000);
    }
}
