package docs;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExaples {
    void CssXpathExaples(){
        $("[data-testid=mail]");
        $(by("data-testid", "email"));

        $("[id=email]");
        $("#email"); // упрощенное обращение к id
        $(byId("email"));
        $x("//*[@id='email']");
        $(byXpath("//*[@id='email']"));

        $("[name=email]");
        $(byName("email"));

        $("[class=email_1]");
        $(".email_1");
        $(".inputtest.email_1");
        $("input.inputtest.email_1");
        $("//input[@class='email_1']");

        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("input.inputtext.login_form_input_box#email[name=email][data-testid=email]");

        // <div>Hello qa.guru</div>
        $(byText("Hello qa.guru"));
        $(withText("lo qa.gu"));
    }
}
