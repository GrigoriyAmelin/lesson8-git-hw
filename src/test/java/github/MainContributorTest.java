package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainContributorTest {

    @Test
    void andreiSontsevShouldBeMainContractor() {
        open("https://github.com/selenide/selenide");
        $(".Layout-sidebar").$(withText("Contributors")).closest(".BorderGrid-cell");
    }
}
