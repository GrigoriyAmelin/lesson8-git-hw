package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    // locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement userNumberInput = $("#userNumber");





    // actions
    public void setFistNameInput(String firstName){
        firstNameInput.setValue(firstName);
    }

    public void setLastNameInput(String lastName){
        lastNameInput.setValue(lastName);
    }
     public void setUserEmailInput(String userEmail){
        userEmailInput.setValue(userEmail);
    }

    public void setUserNumberInput(String userNumber){
        userNumberInput.setValue(userNumber);
    }




}
