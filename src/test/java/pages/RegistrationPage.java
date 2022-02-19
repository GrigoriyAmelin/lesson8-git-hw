package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RadioButtonComponent;
import pages.components.DropDownComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    // components
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RadioButtonComponent radioButtonComponent = new RadioButtonComponent();
    private DropDownComponent dropDownComponent = new DropDownComponent();

    // locators
    private SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            resultTable = $(".table-responsive"),
            subjectInput = $("#subjectsInput");

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

    public RegistrationPage setGenderRadioInput(String gender) {
        radioButtonComponent.setRadioButton(gender);
        return this;
    }

    public RegistrationPage setUserNumberInput(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public void setBirthDate(String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(month, year);
    }

    public RegistrationPage selectSubject(String letter, String subject) {
        subjectInput.sendKeys(letter);
        dropDownComponent.selectSubject(subject);
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultTable.$(byText(fieldName)).parent().shouldHave(text(value));
        return this;
    }


}
