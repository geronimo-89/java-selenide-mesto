package ru.praktikum_services.qa_mesto;

import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum_services.qa_mesto.pageobject.*;

import static com.codeborne.selenide.Selenide.*;

public class MestoTestCards {

    public static final String HOME_PAGE = "https://qa-mesto.praktikum-services.ru/";
    public String userEmail = "2fec8fdb-8b48-4c21-b7f5-0b29ba0d1f38@yandex.ru";
    public String password = "password";
    private SignIn signIn;
    private Home homePage;

    @Before
    public void setUp() {
        Configuration.browserSize = "2560x1440";
        homePage = open(HOME_PAGE, Home.class);
        boolean userIsLoggedIn = homePage.userHeader.isDisplayed();
        if (!userIsLoggedIn) {
            signIn = open(HOME_PAGE, SignIn.class);
            homePage = signIn.login(userEmail, password);
        }
    }

    @Test
    public void getCardsNumber() {
        Configuration.timeout = 5_000;
        homePage
                .getNumberOfCards();
    }

    @Test
    public void getCardText() {
        homePage
                .getCardText(15);
    }
//    @After
//    public void logOut() {
//        homePage.logOut();
//    closeWebDriver();
//    }
//
}
