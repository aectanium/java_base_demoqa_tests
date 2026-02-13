package tests;


import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestAutomationPracticeForm  extends TestBase{
    @Test
    void AllFieldsFilledInTest() {
        //Filling out the form
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("D");
        $("#userEmail").setValue("1@ya.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("option[value='1987']").click();
        $(".react-datepicker__month-select").click();
        $("option[value='4']").click();
        $(".react-datepicker__day.react-datepicker__day--007").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("176061-yablochnyj_pejzazh-yabloko-illustracia-prirodnyj_landshaft-purpur-500x.jpg");
        $("#currentAddress").setValue("Baker Street, 221B");
        $("#state").scrollIntoView(true).click();
        $("#state").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").$(byText("Jaiselmer")).click();
        $("#submit").click();
        //sleep(10000);
        //Checking the completed form
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        SelenideElement table = $(".table-responsive");
        table.$(byText("Student Name")).parent().shouldHave(text("Alex D"));
        table.$(byText("Student Email")).parent().shouldHave(text("1@ya.com"));
        table.$(byText("Gender")).parent().shouldHave(text("Male"));
        table.$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        table.$(byText("Date of Birth")).parent().shouldHave(text("07 May,1987"));
        table.$(byText("Subjects")).parent().shouldHave(text("Maths"));
        table.$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        table.$(byText("Picture")).parent().shouldHave(text("176061-yablochnyj_pejzazh-yabloko-illustracia-prirodnyj_landshaft-purpur-500x.jpg"));
        table.$(byText("Address")).parent().shouldHave(text("Baker Street, 221B"));
        table.$(byText("State and City")).parent().shouldHave(text("Rajasthan Jaiselmer"));
        }
    @Test
    void RequiredFieldsOnlyTest() {
        //Filling out the form
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("D");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#submit").scrollTo().click();
        //sleep(10000);
        //Checking the completed form
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        SelenideElement table = $(".table-responsive");
        table.$(byText("Student Name")).parent().shouldHave(text("Alex D"));
        table.$(byText("Gender")).parent().shouldHave(text("Male"));
        table.$(byText("Mobile")).parent().shouldHave(text("1234567890"));
    }
    }

