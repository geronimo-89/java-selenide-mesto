package ru.praktikum_services.qa_mesto.nopageobject;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static ru.praktikum_services.qa_mesto.Email.*;

public class MestoTest {

    public static final String HOME_PAGE = "https://qa-mesto.praktikum-services.ru/";
    public String email;

    @Before
    public void setUp() {
        //Configuration.browser = "firefox";
        Configuration.browserSize = "2560x1440";
        open(HOME_PAGE);
    }

    @Test
    public void createNewUser() {
        $(byLinkText("Регистрация")).click();
        email = generateRandomEmail();
        System.out.println("User registered with email: " + email);
        $(byId("email")).setValue(email);
        $(byId("password")).setValue("password");
        $(byText("Зарегистрироваться")).click();
        $(byText("Вы успешно зарегистрировались")).should(appear);
    }

    @Test
    public void getCardsNumber() {
        Configuration.timeout = 10_000;
        email = "5d186af3-bf82-4d3a-83b0-dae0d9ea7ca7@yandex.ru";
        $(byId("email")).setValue(email);
        $(byId("password")).setValue("password");
        $(byText("Войти")).click();
        System.out.println("User logged in with email: " + email);
        $x(".//ul[@class='places__list']/li[last()]").shouldBe(visible);
        Integer countCards = $$(byClassName("card__title")).size();
        System.out.println("Number of cards on the page: " + countCards);


    }

}
