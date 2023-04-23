package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

    static Faker faker = new Faker(new Locale("en"));

    public static String getApprovedCardNumber() {
    return "4444444444444441";
    }

    public static String getDeclinedCardNumber() {
    return "4444444444444442";
    }

    public static String getShortCardNumber() {
        return "444444444444444";
    }

    public static String getCurrentMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getZeroMont(){
        return "00";
    }

    public static String getInvalidMont(){
        return "13";
    }

    public static String getPastMont(){
        return LocalDate.now().minusMonths(2).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getValidYear(){
        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getCurrentYear(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getZeroYear(){
        return "00";
    }

    public static String getInvalidFutureYear(){
        return LocalDate.now().plusYears(55).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getPastYear(){
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getValidOwner(){
        return "Oleg Vlasov";
    }

    public static String getOnlyOwnersName(){
        return "Oleg";
    }

    public static String getOnlyOwnersSurname(){
        return  "Vlasov";
    }

    public static String getOwnerInCyrillic(){
        return "Олег Власов";
    }

    public static String getOwnerWithNumbers(){
        return "Oleg 1392";
    }

    public static String getOwnerWithSymbol(){
        return "Oleg ###";
    }

    public static String getOwnerWithoutSpace(){
        return "OlegVlasov";
    }

    public static String getOwnerWithHyphen(){
        return "Oleg-Vlasov";
    }

    public static String getSpaceInsteadOfOwner(){
        return "          ";
    }

    public static String getSpaceBeforeOwner(){
        return "    Oleg Vlasov";
    }

    public static String getValidCVV(){
        return "123";
    }

    public static String getZeroCVV(){
        return "000";
    }

    public static String getShortCVV(){
        return "41";
    }

    @Value
    public static class PaymentForm {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;
    }

    public static PaymentForm getValidPaymentForm() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithInvalidCard() {
        return new PaymentForm(getDeclinedCardNumber(),getCurrentMonth(),getValidYear(),getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithEmptyCardField() {
        return new PaymentForm("",getCurrentMonth(),getValidYear(),getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithShortCardNumber() {
        return new PaymentForm(getShortCardNumber(),getCurrentMonth(),getValidYear(),getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithEmptyOwner() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),"",getValidCVV());
    }

    public static PaymentForm getFormOnlyNameInOwnerField() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getOnlyOwnersName(),getValidCVV());
    }

    public static PaymentForm getFormOnlySurnameInOwnerField() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getOnlyOwnersSurname(),getValidCVV());
    }

    public static PaymentForm getFormWithCyrillicInOwnerField() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getOwnerInCyrillic(),getValidCVV());
    }

    public static PaymentForm getFormWithNumbersInOwnerField() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getOwnerWithNumbers(),getValidCVV());
    }

    public static PaymentForm getFormWithSymbolInOwnerField() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getOwnerWithSymbol(),getValidCVV());
    }

    public static PaymentForm getFormWithoutSpaceInOwnerField() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getOwnerWithoutSpace(),getValidCVV());
    }

    public static PaymentForm getFormWithHyphenInOwnerField() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getOwnerWithHyphen(),getValidCVV());
    }

    public static PaymentForm getFormWithSpaceInsteadOfOwner() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getSpaceInsteadOfOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithSpaceBeforeOwner() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getSpaceBeforeOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithEmptyMonthField() {
        return new PaymentForm(getApprovedCardNumber(),"",getValidYear(),getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithZeroInMonthField() {
        return new PaymentForm(getApprovedCardNumber(),getZeroMont(),getValidYear(),getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithInvalidMonth() {
        return new PaymentForm(getApprovedCardNumber(),getInvalidMont(),getValidYear(),getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithPastMonth() {
        return new PaymentForm(getApprovedCardNumber(),getPastMont(),getCurrentYear(),getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithEmptyYearField() {
        return new PaymentForm(getApprovedCardNumber(), getCurrentMonth(),"",getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithZeroInYearField() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getZeroYear(),getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithInvalidFutureYear() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getInvalidFutureYear(),getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithPastYear() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getPastYear(),getValidOwner(),getValidCVV());
    }

    public static PaymentForm getFormWithEmptyCVV() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getValidOwner(),"");
    }

    public static PaymentForm getFormWithZeroInCVVField() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getValidOwner(),getZeroCVV());
    }

    public static PaymentForm getFormWithShortCVV() {
        return new PaymentForm(getApprovedCardNumber(),getCurrentMonth(),getValidYear(),getValidOwner(),getShortCVV());
    }



}
