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

public class CreditCardTest {
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

    @BeforeEach
    void clearDataBase() {
        SQLData.cleanDataBase();
    }

    @Test
    public void shouldSuccessfulPayment(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getValidPaymentForm());
        payByCreditCard.successfulPayment();
        var paymentStatus = SQLData.getStatusCreditCard();
        assertEquals("APPROVED", paymentStatus);
    }

    @Test
    public void shouldErrorPayment(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithInvalidCard());
        payByCreditCard.bankRefused();
        var paymentStatus = SQLData.getStatusCreditCard();
        assertEquals("DECLINED", paymentStatus);
    }

    @Test
    public void shouldGetErrorWithEmptyCardField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithEmptyCardField());
        payByCreditCard.requiredFieldCard();
    }

    @Test
    public void shouldGetErrorWithShortCardNumber(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithShortCardNumber());
        payByCreditCard.wrongFormatCardField();
    }

    @Test
    public void shouldGetErrorWithEmptyOwnerField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithEmptyOwner());
        payByCreditCard.requiredFieldOwner();
    }

    @Test
    public void shouldGetErrorWithOnlyOwnersName(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormOnlyNameInOwnerField());
        payByCreditCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithOnlyOwnersSurname(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormOnlySurnameInOwnerField());
        payByCreditCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithCyrillicInOwnerField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithCyrillicInOwnerField());
        payByCreditCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithNumbersInOwnerField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithNumbersInOwnerField());
        payByCreditCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithSymbolsInOwnerField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithSymbolInOwnerField());
        payByCreditCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithoutSpaceBetweenNameAndSurname(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithoutSpaceInOwnerField());
        payByCreditCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithHyphenInOwnerField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithHyphenInOwnerField());
        payByCreditCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorOnlySpaceInOwnerField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithSpaceInsteadOfOwner());
        payByCreditCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithSpaceBeforeOwner(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithSpaceBeforeOwner());
        payByCreditCard.wrongFormatOwnerField();
    }

    @Test
    public void shouldGetErrorWithEmptyMonthField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithEmptyMonthField());
        payByCreditCard.requiredFieldMonth();
    }

    @Test
    public void shouldGetErrorWithZeroInMonthField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithZeroInMonthField());
        payByCreditCard.wrongCardDateInMonthField();
    }

    @Test
    public void shouldGetErrorWithInvalidMontField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithInvalidMonth());
        payByCreditCard.wrongCardDateInMonthField();
    }

    @Test
    public void shouldGetErrorWithPastMonth(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithPastMonth());
        payByCreditCard.cardExpiredInMonthField();
    }

    @Test
    public void shouldGetErrorWithEmptyYearField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithEmptyYearField());
        payByCreditCard.requiredFiledYear();
    }

    @Test
    public void shouldGetErrorWithZeroInYearField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithZeroInYearField());
        payByCreditCard.cardExpiredInYearField();
    }

    @Test
    public void shouldGetErrorWithInvalidFutureYearField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithInvalidFutureYear());
        payByCreditCard.wrongCardDateInYearField();
    }

    @Test
    public void shouldGetErrorWithPastYear(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithPastYear());
        payByCreditCard.cardExpiredInYearField();
    }

    @Test
    public void shouldGetErrorWithEmptyCVVField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithEmptyCVV());
        payByCreditCard.requiredFieldCVV();
    }

    @Test
    public void shouldGetErrorWithZeroInCVVField(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithZeroInCVVField());
        payByCreditCard.wrongFormatCVVField();
    }

    @Test
    public void shouldGetErrorWithInvalidInCVV(){
        var homePage = new HomePage();
        var payByCreditCard = homePage.payByCreditCard();
        payByCreditCard.fillPaymentForm(DataHelper.getFormWithShortCVV());
        payByCreditCard.wrongFormatCVVField();
    }


}
