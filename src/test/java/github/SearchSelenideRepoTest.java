package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepoTest {

    @Test
    void shouldFindSelenideInGithub() {

        open("https://github.com");
        $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();

        sleep(5000);


    }
}
