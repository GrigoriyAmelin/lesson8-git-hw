package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DropDownComponent {

    public void selectSubject(String subject) {
        $(byText(subject)).click();
    }
}
