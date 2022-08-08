package ru.praktikum_services.qa_mesto.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.page;

public class Home {

    @FindBy(xpath = ".//ul[@class='places__list']/li[last()]")
    private SelenideElement lastCard;

    @FindAll({@FindBy(className = "card")})
    private ElementsCollection cards;

    @FindBy(className = "header__logout")
    private SelenideElement logOutButton;

    @FindBy(className = "header__user")
    public SelenideElement userHeader;


    public SignIn logOut() {
        logOutButton.click();
        return page(SignIn.class);
    }

    public Home getNumberOfCards() {
        lastCard.shouldBe(visible);
        Integer countCards = cards.size();
        System.out.println("Number of cards on the page: " + countCards);
        return this;
    }

    public Home getCardText(int cardNumber) {
        //String cardText = $$(byClassName("card")).get(1).find(byClassName("card__title")).getText();
        String cardText = cards.get(cardNumber).find(byClassName("card__title")).getText();
        System.out.println("Card number " + cardNumber + ": " + cardText);
        return this;
    }
}
