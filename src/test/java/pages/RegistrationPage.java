package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    // locators
    private SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber");

    private SelenideElement resultTable = $(".table-responsive");

    // actions
    public void openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));
    }

    public void setFistNameInput(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void setLastNameInput(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setUserEmailInput(String userEmail) {
        userEmailInput.setValue(userEmail);
    }

    public void setUserNumberInput(String userNumber) {
        userNumberInput.setValue(userNumber);
    }

    public void checkForm(String fieldName, String value) {
        resultTable.$(byText(fieldName)).parent().shouldHave(text(value));
    }


}
