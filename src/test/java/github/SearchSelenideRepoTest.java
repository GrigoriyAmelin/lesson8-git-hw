package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepoTest {

    @Test
    void shouldFindSelenideInGithub() {

        open("https://github.com/");
        $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();
        $("ul.repo-list li a").click();
        $$("h1").first().shouldHave(text("selenide / selenide"));

        sleep(5000);


    }
}
