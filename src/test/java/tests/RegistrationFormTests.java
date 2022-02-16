package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Grisha";
    String lastName = "Amelin";
    String eMail = "qwerty@mail.ru";

    @BeforeAll
    static void before() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1088";
    }

    @Test
    void practiceFormTest() {
        registrationPage
                .openPage()
                .setFistNameInput(firstName)
                .setLastNameInput(lastName)
                .setUserEmailInput(eMail);


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

        registrationPage.setUserNumberInput("89999452323111");

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

        registrationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", eMail)
                .checkForm("Gender", "Other")
                .checkForm("Mobile", "8999945232")
                .checkForm("Date of Birth", "02 March,1937")
                .checkForm("Subjects", "English, Commerce, Arts")
                .checkForm("Hobbies", "Reading, Sports, Music")
                .checkForm("Picture", "12.jpg")
                .checkForm("Address", "Moscow, Kremlin")
                .checkForm("State and City", "Haryana Panipat");

        System.out.println("итоговый тест прошел!");
    }

}
