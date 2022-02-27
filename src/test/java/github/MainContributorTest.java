package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainContributorTest {

    @Test
    void andreiSontsevShouldBeMainContractor() {
        Configuration.browserSize = "1020x1080";
        open("https://github.com/selenide/selenide");
        $(".Layout-sidebar").$(withText("Contributors")).closest(".BorderGrid-row").scrollTo()
                .$("ul  li").hover();
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));


        sleep(3000);
    }
}
