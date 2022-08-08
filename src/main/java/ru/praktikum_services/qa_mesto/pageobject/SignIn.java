package ru.praktikum_services.qa_mesto.pageobject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class SignIn {

    @FindBy(linkText="Регистрация")
    private SelenideElement registerButton;

    @FindBy(id = "email")
    private SelenideElement emailInputField;

    @FindBy(id = "password")
    private SelenideElement passwordInputField;

    @FindBy(className = "auth-form__button")
    private SelenideElement loginButton;


    public SignUp clickRegisterButton() {
        registerButton.click();
        return page(SignUp.class);
    }

    public SignIn inputEmail(String email) {
        emailInputField.setValue(email);
        return this;
    }

    public SignIn inputPassword(String password) {
        passwordInputField.setValue(password);
        return this;
    }

    public Home clickLoginButton() {
        loginButton.click();
        return page(Home.class);
    }

    public Home login(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickLoginButton();
        return page(Home.class);
    }

}
