package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private SelenideElement paymentButton = $(byText("Купить"));

    private SelenideElement creditButton = $(byText("Купить в кредит"));

    private SelenideElement payCard = $(byText("Оплата по карте"));

    private SelenideElement payCreditCard = $(byText("Кредит по данным карты"));

    public PaymentCardPage payByCard () {
        paymentButton.click();
        payCard.shouldBe(Condition.visible);
        return new PaymentCardPage();
    }

  public CreditCardPage payByCreditCard () {
        creditButton.click();
        payCreditCard.shouldBe(Condition.visible);
        return new CreditCardPage();
    }


}
