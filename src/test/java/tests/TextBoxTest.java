package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.enabled;
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
        open("/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Grisha");
        $("#lastName").setValue("Amelin");
        $("#userEmail").setValue("qwerty@mail.ru");

        //Выбор радио-баттонов и проверка их активности после выбора
        $("[class='custom-control custom-radio custom-control-inline'] #gender-radio-1")
                .shouldNotBe(selected);
        $(byText("Male")).click();
        $("[class='custom-control custom-radio custom-control-inline'] #gender-radio-1")
                .shouldBe(selected);
        $(byText("Other")).click();
        $("[class='custom-control custom-radio custom-control-inline'] #gender-radio-3")
                .shouldBe(selected);
        $("[class='custom-control custom-radio custom-control-inline'] #gender-radio-1")
                .shouldNotBe(selected);

        $("#userNumber").setValue("89999452323111");

        // Проверка выбора предмета из выпадающего списка
        $("#subjectsInput").sendKeys("e");
        $(byText("English")).click();
        $("#subjectsInput").sendKeys("erc");
        $(byText("Commerce")).click();
        $("#subjectsInput").sendKeys("a");
        $(byText("Arts")).click();
        $("#subjectsInput").setValue("erc");

        //Выбор чек-боксов и проверка их активности после выбора
        $(byText("Reading")).click();
        $("#hobbies-checkbox-1").parent().click();
        $("[class='custom-control custom-checkbox custom-control-inline'] #hobbies-checkbox-1")
                .shouldBe(selected);
        $("[class='custom-control custom-checkbox custom-control-inline'] #hobbies-checkbox-3")
                .shouldNotBe(selected);
        $("#hobbies-checkbox-3").scrollTo().parent().click();
        $("[class='custom-control custom-checkbox custom-control-inline'] #hobbies-checkbox-3")
                .shouldBe(selected);

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/11.jpg"));
        File myfile = new File("src/test/resources/img/12.jpg");
        $("#uploadPicture").uploadFile(myfile);

//        $("#hobbies-checkbox-1").shouldBe(enabled);
        $("#currentAddress").setValue("Moscow, Kremlin");
        $("#submit").click();
//
//        $("#output").shouldHave(text("grisha"), text("gri@gri.com"), text("some address 1"),
//                text("some address 2"));
        System.out.println("итоговый тест прошел!");

//        $("#currentAddress", 1).shouldHave(text("some address 1")); // 1 вариант поиска второго элемента current address
//        $("#output").$("#currentAddress").shouldHave(text("some address 1")); // 2 вариант поиска
//        $("#output #currentAddress").shouldHave(text("some address 1")); // 3 вариант поиска
    }

}

