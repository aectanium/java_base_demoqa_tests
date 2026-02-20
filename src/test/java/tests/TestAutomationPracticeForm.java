package tests;


import org.junit.jupiter.api.Test;
import test.data.RegistrationPage;
import static test.data.TestData.*;

public class TestAutomationPracticeForm extends TestBase {

    private RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void allFieldsFilledInTest() {
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(USER_EMAIL)
                .setGender(GENDER)
                .setNumber(USER_NUMBER)
                .setBirthDate(BIRTH_YEAR, BIRTH_MONTH, BIRTH_DAY)
                .setSubjects(SUBJECTS)
                .setHobbies(HOBBIES)
                .uploadPicture(UPLOAD_PICTURE)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setState(STATE)
                .setCity(CITY)
                .clickSubmit();

        registrationPage.checkSuccessModalAppears()
                .getResultTable()
                .checkStudentName(FIRST_NAME, LAST_NAME)
                .checkStudentEmail(USER_EMAIL)
                .checkGender(GENDER)
                .checkMobile(USER_NUMBER)
                .checkDateOfBirth(DATE_OF_BIRTH)
                .checkSubjects(SUBJECTS)
                .checkHobbies(HOBBIES)
                .checkPicture(UPLOAD_PICTURE)
                .checkAddress(CURRENT_ADDRESS)
                .checkStateAndCity(STATE, CITY);
    }

    @Test
    void requiredFieldsOnlyTest() {
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setNumber(USER_NUMBER)
                .scrollToSubmitAndClick();

        registrationPage.checkSuccessModalAppears()
                .getResultTable()
                .checkStudentName(FIRST_NAME, LAST_NAME)
                .checkGender(GENDER)
                .checkMobile(USER_NUMBER);
    }
}