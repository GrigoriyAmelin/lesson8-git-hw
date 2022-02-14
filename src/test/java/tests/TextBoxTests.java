package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

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

        // Установка даты в календаре
        $("#dateOfBirthInput").click();
        // вариант 1 выбора элемента списка
        $(".react-datepicker__month-select").$(byText("October")).click();
        // вариант 2 выбора элемента списка
        $(".react-datepicker__month-select").selectOption("November");
        // вариант 3 выбора элемента списка
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__year-select").selectOptionByValue("1937");
        $x("//div[@class='react-datepicker']/button[text()='Previous Month']").click();
        $(".react-datepicker__day--002").click();


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

        $("#currentAddress").setValue("Moscow, Kremlin");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();
        $("#submit").click();

        // Проверки финальной формы
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Grisha Amelin"),
                text("qwerty@mail.ru"),
                text("Other"),
                text("8999945232"),
                text("02 March,1937"),
                text("English, Commerce, Arts"),
                text("Reading, Sports, Music"),
                text("12.jpg"),
                text("Moscow, Kremlin"),
                text("Haryana Panipat")
        );
        $(".table-responsive").$(byText("Student Name")).parent()
                .shouldHave(text("Grisha Amelin"));
        $(".table-responsive").$(byText("Student Email")).parent()
                .shouldHave(text("qwerty@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent()
                .shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent()
                .shouldHave(text("8999945232"));
        $(".table-responsive").$(byText("Date of Birth")).parent()
                .shouldHave(text("02 March,1937"));
        $(".table-responsive").$(byText("Subjects")).parent()
                .shouldHave(text("English, Commerce, Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent()
                .shouldHave(text("Reading, Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent()
                .shouldHave(text("12.jpg"));
        $(".table-responsive").$(byText("Address")).parent()
                .shouldHave(text("Moscow, Kremlin"));
        $(".table-responsive").$(byText("State and City")).parent()
                .shouldHave(text("Haryana Panipat"));

        System.out.println("итоговый тест прошел!");
    }

}

