package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DropDownComponent {

    public void select(String subject) {
        $(byText(subject)).click();
    }
}
