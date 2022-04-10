package tests.qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.*;

public class AnnotatedSelenideTest extends TestBase {

    public static final String repository = "GrigoriyAmelin/lesson7-allure";
    public static final String tabName = "Issues";
    public static final String tabSearchText = "is:issue is:open ";

    @Test
    @Owner("Grigoriy Amelin")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Задачи в репозитории")
    @Story("Поиск задач в репозитории")
    @DisplayName("Проверка пустой вкладки \"Issue\" для существующего пользователя")
    @Description("Проверка существования пустой страницы для пользователя. Проверка корректного отображения" +
            "текста в поисковой строке на вкладке \"Issue\"")
    @Link(value = "GrigoriyAmelin/lesson7-allure/issues", url = "https://github.com")
        public void testIssueSearchWithAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        parameter("Репозиторий", repository);
        parameter("Таб", tabName);

        AnnotatedSelenideWebSteps steps = new AnnotatedSelenideWebSteps();

        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.clickSubmit();
        steps.openRepository(repository);
        steps.openIssueTab(tabName);
        steps.shouldExistTabSearchText(tabSearchText, tabName);
        steps.shouldBeTabName(tabName);
    }
}
