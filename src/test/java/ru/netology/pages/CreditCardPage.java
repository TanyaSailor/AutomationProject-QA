package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreditCardPage{

    private SelenideElement cardNumber = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $("[placeholder='08']");
    private SelenideElement year = $("[placeholder='22']");
    private SelenideElement owner = $(byText("Владелец")).parent().$(".input__control");
    private SelenideElement cvc = $("[placeholder='999']");
    private SelenideElement continueButton = $(byText("Продолжить"));


    public void fillPaymentForm(DataHelper.PaymentForm paymentForm) {
        cardNumber.setValue(paymentForm.getCardNumber());
        month.setValue(paymentForm.getMonth());
        year.setValue(paymentForm.getYear());
        owner.setValue(paymentForm.getOwner());
        cvc.setValue(paymentForm.getCvc());
        continueButton.click();
    }

    private SelenideElement successNotification = $(byText("Успешно"));

    private SelenideElement errorNotification = $(byText("Ошибка"));

    private SelenideElement requiredFieldCard = $(byText("Номер карты")).parent().$(byText("Поле обязательно для заполнения"));

    private SelenideElement requiredFieldMonth = $(byText("Месяц")).parent().$(byText("Неверный формат"));

    private SelenideElement requiredFieldOwner = $(byText("Владелец")).parent().$(byText("Поле обязательно для заполнения"));

    private SelenideElement requiredFieldYear = $(byText("Год")).parent().$(byText("Поле обязательно для заполнения"));

    private SelenideElement requiredFieldCVV = $(byText("CVC/CVV")).parent().$(byText("Поле обязательно для заполнения"));

    private SelenideElement wrongFormatCardField =$(byText("Номер карты")).parent().$(byText("Неверный формат"));

    private SelenideElement wrongFormatOwnerField = $(byText("Владелец")).parent().$(byText("Неверный формат"));

    private SelenideElement wrongFormatCVVField = $(byText("CVC/CVV")).parent().$(byText("Неверный формат"));

    private SelenideElement incorrectCardExpirationDateInMonth = $(byText("Месяц")).parent().$(byText("Неверно указан срок действия карты"));

    private SelenideElement incorrectCardExpirationDateInYear = $(byText("Год")).parent().$(byText("Неверно указан срок действия карты"));

    private SelenideElement cardExpiredInMonth = $(byText("Месяц")).parent().$(byText("Истёк срок действия карты"));

    private SelenideElement cardExpiredInYear = $(byText("Год")).parent().$(byText("Истёк срок действия карты"));

    public void successfulPayment() {
        successNotification.shouldBe(Condition.visible, Duration.ofSeconds(13));
    }

    public void bankRefused() {

        errorNotification.shouldBe(Condition.visible, Duration.ofSeconds(13));
    }

    public void requiredFieldCard() {
        requiredFieldCard.shouldBe(Condition.visible);
    }

    public void requiredFieldOwner() {
        requiredFieldOwner.shouldBe(Condition.visible);
    }

    public void requiredFieldMonth() {
        requiredFieldMonth.shouldBe(Condition.visible);
    }

    public void requiredFiledYear() {
        requiredFieldYear.shouldBe(Condition.visible);
    }

    public void requiredFieldCVV() {
        requiredFieldCVV.shouldBe(Condition.visible);
    }

    public void wrongFormatCardField() {
        wrongFormatCardField.shouldBe(Condition.visible);
    }

    public void wrongFormatOwnerField() {
        wrongFormatOwnerField.shouldBe(Condition.visible);
    }

    public void wrongFormatCVVField() {
        wrongFormatCVVField.shouldBe(Condition.visible);
    }

    public void wrongCardDateInMonthField() {
        incorrectCardExpirationDateInMonth.shouldBe(Condition.visible);
    }

    public void wrongCardDateInYearField() {
        incorrectCardExpirationDateInYear.shouldBe(Condition.visible);
    }

    public void cardExpiredInMonthField() {
        cardExpiredInMonth.shouldBe(Condition.visible);
    }

    public void cardExpiredInYearField() {
        cardExpiredInYear.shouldBe(Condition.visible);
    }
}

