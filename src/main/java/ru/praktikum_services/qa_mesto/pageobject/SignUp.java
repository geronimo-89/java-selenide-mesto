package ru.praktikum_services.qa_mesto.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class SignUp {

    @FindBy(id = "email")
    private SelenideElement emailInputField;

    @FindBy(id = "password")
    private SelenideElement passwordInputField;

    @FindBy(className = "auth-form__button")
    private SelenideElement registerConfirmButton;

    @FindBy(xpath = ".//p[text()='Вы успешно зарегистрировались']")
    private SelenideElement registrationConfirmationWindow;

    public SignUp inputEmail(String email) {
        emailInputField.setValue(email);
        System.out.println("User registered with email: " + email);
        return this;
    }
    public SignUp inputPassword(String password) {
        passwordInputField.setValue(password);
        return this;
    }

    public Home clickRegisterConfirmButton() {
        registerConfirmButton.click();
        registrationConfirmationWindow.should(appear);
        return page(Home.class);
    }

}
