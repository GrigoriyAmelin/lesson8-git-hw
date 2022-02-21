package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Grisha";
    String lastName = "Amelin";
    String eMail = mail;
    String userNumber = phone;
    String dateOfBirth = "02 October,1937";
    String spellEnglish = "e";
    String subjectEnglish = "English";
    String spellCommerce = "erc";
    String subjectCommerce = "Commerce";
    String spellArts = "a";
    String subjectArts = "Arts";
    String hobbyReading = "Reading";
    String hobbySports = "Sports";
    String hobbyMusic = "Music";
    String uploadedFile = "12.jpg";
    String genderMale = "Male";
    String genderOther = "Other";
    String currentAddress = "Moscow, Kremlin";
    String state = "Haryana";
    String city = "Panipat";
    String submittingFormHeader = "Thanks for submitting the form";

    @Test
    void practiceFormTest() {
        registrationPage
                .openPage()
                .setFistNameInput(firstName)
                .setLastNameInput(lastName)
                .setUserEmailInput(eMail)
                .setGenderRadioInput(genderMale)
                .setGenderRadioInput(genderOther)
                .setUserNumberInput(userNumber)
                .selectSubject(spellEnglish, subjectEnglish)
                .selectSubject(spellCommerce, subjectCommerce)
                .selectSubject(spellArts, subjectArts)
                .selectHobby(hobbyReading)
                .selectHobby(hobbySports)
                .selectHobby(hobbyMusic)
                .uploadFile(uploadedFile)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .setBirthDate("October", "1937");

        registrationPage
                .clickSubmit()
                .checkGoToSubmittingForm(submittingFormHeader);

        registrationPage
                .checkFillingForm(firstName + " " + lastName)
                .checkFillingForm(eMail)
                .checkFillingForm(genderOther)
                .checkFillingForm(userNumber)
                .checkFillingForm(dateOfBirth)
                .checkFillingForm(subjectEnglish + ", " + subjectCommerce + ", " + subjectArts)
                .checkFillingForm(hobbyReading + ", " + hobbySports + ", " + hobbyMusic)
                .checkFillingForm(uploadedFile)
                .checkFillingForm(currentAddress)
                .checkFillingForm(state + " " + city);

        registrationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", eMail)
                .checkForm("Gender", genderOther)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", dateOfBirth)
                .checkForm("Subjects", subjectEnglish + ", " + subjectCommerce + ", " + subjectArts)
                .checkForm("Hobbies", hobbyReading + ", " + hobbySports + ", " + hobbyMusic)
                .checkForm("Picture", uploadedFile)
                .checkForm("Address", currentAddress)
                .checkForm("State and City", state + " " + city);

        System.out.println("\n=============== Test passed! ===============\n");
    }
}
