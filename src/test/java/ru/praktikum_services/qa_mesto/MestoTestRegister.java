package ru.praktikum_services.qa_mesto;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum_services.qa_mesto.pageobject.SignIn;

import static com.codeborne.selenide.Selenide.*;
import static ru.praktikum_services.qa_mesto.Email.*;

public class MestoTestRegister {

    public static final String HOME_PAGE = "https://qa-mesto.praktikum-services.ru/";
    public String password = "password";

    @Before
    public void setUp() {
        Configuration.browserSize = "2560x1440";
    }

    @Test
    public void createNewUser() {
        SignIn signIn = open(HOME_PAGE, SignIn.class);
        signIn
                .clickRegisterButton()
                .inputEmail(generateRandomEmail())
                .inputPassword(password)
                .clickRegisterConfirmButton();
    }
}