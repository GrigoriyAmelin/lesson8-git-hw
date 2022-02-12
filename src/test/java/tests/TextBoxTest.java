package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {

    @BeforeAll
    static void before() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1088";
    }

    @Test
    void successOpenPracticeFormTest() {
        open("");

        $x("//div[@class='category-cards']/div[2]").click();
        $(".main-header").shouldHave(text("Forms"));
        $x("//div[@class='accordion']/div[2]/div[@class='element-list collapse show']/ul/li").click();
        $(".main-header").shouldHave(text("Practice Form"));
    }

    @Test
    void practiceFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Grisha");
        $("#lastName").setValue("Amelin");
        $("#userEmail").setValue("qwerty@mail.ru");
        $(byText("Male")).click();
        $(byText("Other")).click();

//        $("#submit").click();
//
//        $("#output").shouldHave(text("grisha"), text("gri@gri.com"), text("some address 1"),
//                text("some address 2"));
        System.out.println("итоговый тест прошел!");

//        $("#currentAddress", 1).shouldHave(text("some address 1")); // 1 вариант поиска второго элемента current address
//        $("#output").$("#currentAddress").shouldHave(text("some address 1")); // 2 вариант поиска
//        $("#output #currentAddress").shouldHave(text("some address 1")); // 3 вариант поиска
    }

}

