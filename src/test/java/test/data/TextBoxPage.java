package test.data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement elementsCard = $$(".card-body").findBy(text("Elements"));
    private final SelenideElement textBoxLink = $$(".router-link").findBy(text("Text Box"));
    private final SelenideElement userNameInput = $("[id=userName]");
    private final SelenideElement userEmailInput = $("[id=userEmail]");
    private final SelenideElement currentAddressInput = $("[id=currentAddress]");
    private final SelenideElement permanentAddressInput = $("[id=permanentAddress]");
    private final SelenideElement submitButton = $("[id=submit]");

    private final SelenideElement outputName = $("[id=output] [id=name]");
    private final SelenideElement outputEmail = $("[id=output] [id=email]");
    private final SelenideElement outputCurrentAddress = $("[id=output] [id=currentAddress]");
    private final SelenideElement outputPermanentAddress = $("[id=output] [id=permanentAddress]");

    public TextBoxPage openElementsSection() {
        elementsCard.scrollIntoView(true).click();
        return this;
    }

    public TextBoxPage openTextBoxPage() {
        textBoxLink.click();
        return this;
    }

    public TextBoxPage setUserName(String userName) {
        userNameInput.setValue(userName);
        return this;
    }

    public TextBoxPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public TextBoxPage clickSubmit() {
        submitButton.click();
        return this;
    }

    // Исправленные методы с использованием цепочки вызовов
    public TextBoxPage fillAllFields(String userName, String userEmail, String currentAddress, String permanentAddress) {
        return setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress);
    }

    public TextBoxPage fillRequiredFields(String userName, String userEmail) {
        return setUserName(userName)
                .setUserEmail(userEmail);
    }

    public TextBoxPage verifyUserName(String expectedUserName) {
        outputName.shouldHave(text(expectedUserName));
        return this;
    }

    public TextBoxPage verifyUserEmail(String expectedUserEmail) {
        outputEmail.shouldHave(text(expectedUserEmail));
        return this;
    }

    public TextBoxPage verifyCurrentAddress(String expectedCurrentAddress) {
        outputCurrentAddress.shouldHave(text(expectedCurrentAddress));
        return this;
    }

    public TextBoxPage verifyPermanentAddress(String expectedPermanentAddress) {
        outputPermanentAddress.shouldHave(text(expectedPermanentAddress));
        return this;
    }

    public TextBoxPage verifyAllFields(String userName, String userEmail, String currentAddress, String permanentAddress) {
        return verifyUserName(userName)
                .verifyUserEmail(userEmail)
                .verifyCurrentAddress(currentAddress)
                .verifyPermanentAddress(permanentAddress);
    }

    public TextBoxPage verifyRequiredFields(String userName, String userEmail) {
        return verifyUserName(userName)
                .verifyUserEmail(userEmail);
    }
}