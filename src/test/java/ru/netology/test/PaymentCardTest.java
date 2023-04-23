package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLData;
import ru.netology.pages.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentCardTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }


    @Test
    public void shouldSuccessfulPayment(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getValidPaymentForm());
        payByCard.successfulPayment();
        // дописать проверку статуса в бд
    }

    @Test
    public void shouldErrorPayment(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithInvalidCard());
        payByCard.bankRefused();
        // дописать проверку статуса в бд
    }

    @Test
    public void shouldGetErrorWithEmptyCardField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithEmptyCardField());
        payByCard.requiredFieldCard();
    }

    @Test
    public void shouldGetErrorWithShortCardNumber(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithShortCardNumber());
        payByCard.wrongFormatCardField();
    }

    @Test
    public void shouldGetErrorWithEmptyOwnerField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithEmptyOwner());
        payByCard.requiredFieldOwner();
    }

    @Test
    public void shouldGetErrorWithOnlyOwnersName(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormOnlyNameInOwnerField());
        payByCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithOnlyOwnersSurname(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormOnlySurnameInOwnerField());
        payByCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithCyrillicInOwnerField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithCyrillicInOwnerField());
        payByCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithNumbersInOwnerField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithNumbersInOwnerField());
        payByCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithSymbolsInOwnerField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithSymbolInOwnerField());
        payByCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithoutSpaceBetweenNameAndSurname(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithoutSpaceInOwnerField());
        payByCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithHyphenInOwnerField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithHyphenInOwnerField());
        payByCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorOnlySpaceInOwnerField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithSpaceInsteadOfOwner());
        payByCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithSpaceBeforeOwner(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithSpaceBeforeOwner());
        payByCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithEmptyMonthField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithEmptyMonthField());
        payByCard.requiredFieldMonth();
    }

    @Test
    public void shouldGetErrorWithZeroInMonthField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithZeroInMonthField());
        payByCard.wrongCardDateInMonthField();
    }

    @Test
    public void shouldGetErrorWithInvalidMontField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithInvalidMonth());
        payByCard.wrongCardDateInMonthField();
    }

    @Test
    public void shouldGetErrorWithPastMonth(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithPastMonth());
        payByCard.cardExpiredInMonthField();
    }

    @Test
    public void shouldGetErrorWithEmptyYearField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithEmptyYearField());
        payByCard.requiredFiledYear();
    }

    @Test
    public void shouldGetErrorWithZeroInYearField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithZeroInYearField());
        payByCard.cardExpiredInYearField();
    }

    @Test
    public void shouldGetErrorWithInvalidFutureYearField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithInvalidFutureYear());
        payByCard.wrongCardDateInYearField();
    }

    @Test
    public void shouldGetErrorWithPastYear(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithPastYear());
        payByCard.cardExpiredInYearField();
    }

    @Test
    public void shouldGetErrorWithEmptyCVVField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithEmptyCVV());
        payByCard.requiredFieldCVV();
    }

    @Test
    public void shouldGetErrorWithZeroInCVVField(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithZeroInCVVField());
        payByCard.wrongFormatCVVField();
    }

    @Test
    public void shouldGetErrorWithInvalidInCVV(){
        var homePage = new HomePage();
        var payByCard = homePage.payByCard();
        payByCard.fillPaymentForm(DataHelper.getFormWithShortCVV());
        payByCard.wrongFormatCVVField();
    }


}
