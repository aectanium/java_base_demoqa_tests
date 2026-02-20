package test.data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private final SelenideElement resultTable = $(".table-responsive");

    public ResultTableComponent checkResult(String fieldName, String expectedValue) {
        resultTable.$(byText(fieldName)).parent().shouldHave(text(expectedValue));
        return this;
    }

    public ResultTableComponent checkStudentName(String firstName, String lastName) {
        return checkResult("Student Name", firstName + " " + lastName);
    }

    public ResultTableComponent checkStudentEmail(String email) {
        return checkResult("Student Email", email);
    }

    public ResultTableComponent checkGender(String gender) {
        return checkResult("Gender", gender);
    }

    public ResultTableComponent checkMobile(String mobile) {
        return checkResult("Mobile", mobile);
    }

    public ResultTableComponent checkDateOfBirth(String dateOfBirth) {
        return checkResult("Date of Birth", dateOfBirth);
    }

    public ResultTableComponent checkSubjects(String subjects) {
        return checkResult("Subjects", subjects);
    }

    public ResultTableComponent checkHobbies(String hobbies) {
        return checkResult("Hobbies", hobbies);
    }

    public ResultTableComponent checkPicture(String pictureName) {
        return checkResult("Picture", pictureName);
    }

    public ResultTableComponent checkAddress(String address) {
        return checkResult("Address", address);
    }

    public ResultTableComponent checkStateAndCity(String state, String city) {
        return checkResult("State and City", state + " " + city);
    }
}
