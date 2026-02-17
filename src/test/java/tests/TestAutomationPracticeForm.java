package tests;


import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestAutomationPracticeForm  extends TestBase{
    private String firstName;
    private String lastName;
    private String userEmail;
    private String genterWrapper;
    private String userNumber;
    private String subjectsInput;
    private String hobbiesWrapper;
    private String uploadPicture;
    private String currentAddress;
    private String state;
    private String city;
    private String birthYear;
    private String birthMonth;
    private String birthDay;
    private String dateOfBirth;
    @BeforeEach
    public void setup() {
        //userName = getRandomString(10);
        firstName = "Alex";
        lastName = "D";
        userEmail = "1@ya.com";
        genterWrapper = "Male";
        userNumber = "1234567890";
        subjectsInput = "Math";
        hobbiesWrapper = "Reading";
        uploadPicture = "176061-yablochnyj_pejzazh-yabloko-illustracia-prirodnyj_landshaft-purpur-500x.jpg";
        currentAddress = "Baker Street, 221B";
        state = "Rajasthan";
        city = "Jaiselmer";
        birthYear = "1987";
        birthMonth = "4";
        birthDay = "007";
        dateOfBirth ="07 May,1987";
    }
    @Test
    void allFieldsFilledInTest() {
        //Filling out the form
        open("");
        $$(".card-body").findBy(text("Forms")).scrollIntoView(true).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        //sleep(10000);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("option[value='"+ birthYear + "']").click();
        $(".react-datepicker__month-select").click();
        $("option[value='"+ birthMonth +"']").click();
        $(".react-datepicker__day.react-datepicker__day--"+ birthDay).click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbiesWrapper)).click();
        $("#uploadPicture").uploadFromClasspath(uploadPicture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").scrollIntoView(true).click();
        $("#state").$(byText(state)).scrollIntoView(true).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();
        //sleep(10000);
        //Checking the completed form
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        SelenideElement table = $(".table-responsive");
        table.$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        table.$(byText("Student Email")).parent().shouldHave(text(userEmail));
        table.$(byText("Gender")).parent().shouldHave(text(genterWrapper));
        table.$(byText("Mobile")).parent().shouldHave(text(userNumber));
        table.$(byText("Date of Birth")).parent().shouldHave(text(dateOfBirth));
        table.$(byText("Subjects")).parent().shouldHave(text(subjectsInput));
        table.$(byText("Hobbies")).parent().shouldHave(text(hobbiesWrapper));
        table.$(byText("Picture")).parent().shouldHave(text(uploadPicture));
        table.$(byText("Address")).parent().shouldHave(text(currentAddress));
        table.$(byText("State and City")).parent().shouldHave(text(state + " " + city));
        }

    @Test
    void requiredFieldsOnlyTest() {
        //Filling out the form
        open("");
        $$(".card-body").findBy(text("Forms")).scrollIntoView(true).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").scrollTo().click();
        //sleep(10000);
        //Checking the completed form
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        SelenideElement table = $(".table-responsive");
        table.$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        table.$(byText("Gender")).parent().shouldHave(text(genterWrapper));
        table.$(byText("Mobile")).parent().shouldHave(text(userNumber));
    }
    }

