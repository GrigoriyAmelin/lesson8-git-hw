package pages.components;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckBoxComponent {

    public void checkBoxSelect(String hobbie) {
        $(byText(hobbie)).parent().$(".custom-control-label").click();
    }
}
