package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RadioButtonComponent {

    public void setRadioButton(String gender) {
        $(byText(gender)).click();
    }
}
