package test.data;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final CalendarComponent calendar = new CalendarComponent();
    private final ResultTableComponent resultTable = new ResultTableComponent();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement modalHeader = $(".modal-header");

    public RegistrationPage openPage() {
        open("");
        $$(".card-body").findBy(text("Forms")).scrollIntoView(true).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage setBirthDate(String year, String month, String day) {
        dateOfBirthInput.click();
        calendar.setDate(year, month, day);
        return this;
    }

    public RegistrationPage setBirthDate(int year, int month, int day) {
        dateOfBirthInput.click();
        calendar.setDate(year, month, day);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateDropdown.scrollIntoView(true).click();
        stateDropdown.$(byText(state)).scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityDropdown.click();
        cityDropdown.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage scrollToSubmitAndClick() {
        submitButton.scrollTo().click();
        return this;
    }

    public RegistrationPage checkSuccessModalAppears() {
        modalHeader.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public ResultTableComponent getResultTable() {
        return resultTable;
    }
}