package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void before() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1088";
    }

    @Test
    void successFillTest() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("grisha");
        $("#userEmail").setValue("gri@gri.com");
        $("#currentAddress").setValue("some address 1");
        $("#permanentAddress").setValue("some address 2");
        $("#submit").click();

        $("#output").shouldHave(text("grisha"), text("gri@gri.com"), text("some address 1"),
                text("some address 2"));
        System.out.println("итоговый тест прошел!");

        $("#currentAddress", 1).shouldHave(text("some address 1")); // 1 вариант поиска второго элемента current address
        $("#output").$("#currentAddress").shouldHave(text("some address 1")); // 2 вариант поиска
        $("#output #currentAddress").shouldHave(text("some address 1")); // 3 вариант поиска
    }

}

