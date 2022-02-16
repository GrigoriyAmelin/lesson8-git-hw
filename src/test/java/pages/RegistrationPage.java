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
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));

        return this;
    }

    public RegistrationPage setFistNameInput(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastNameInput(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmailInput(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage setUserNumberInput(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultTable.$(byText(fieldName)).parent().shouldHave(text(value));

        return this;
    }


}
