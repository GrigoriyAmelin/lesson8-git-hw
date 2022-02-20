package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckBoxComponent;
import pages.components.RadioButtonComponent;
import pages.components.DropDownComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    // components
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RadioButtonComponent radioButtonComponent = new RadioButtonComponent();
    private DropDownComponent dropDownComponent = new DropDownComponent();
    private CheckBoxComponent checkBoxComponent = new CheckBoxComponent();

    // locators
    private SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            resultTable = $(".table-responsive"),
            subjectInput = $("#subjectsInput"),
            uploadFile = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            submittingFormHeaderTitle = $("#example-modal-sizes-title-lg");

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
        dropDownComponent.select(subject);
        return this;
    }

    public RegistrationPage selectHobby(String hobby) {
        checkBoxComponent.checkBoxSelect(hobby);
        return this;
    }

    public RegistrationPage uploadFile(String uploadedFileName) {
        File myfile = new File("src/test/resources/img/" + uploadedFileName);
        uploadFile.uploadFile(myfile);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateInput.scrollTo().click();
        dropDownComponent.select(state);
        cityInput.scrollTo().click();
        dropDownComponent.select(city);
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.scrollTo().click();
        return this;
    }

    public RegistrationPage checkGoToSubmittingForm(String submittingFormHeader) {
        submittingFormHeaderTitle.shouldHave(text(submittingFormHeader));
        return this;
    }

    public RegistrationPage checkFillingForm(String value) {
        resultTable.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkForm(String formName, String value) {
        resultTable.$(byText(formName)).parent().shouldHave(text(value));
        return this;
    }
}

