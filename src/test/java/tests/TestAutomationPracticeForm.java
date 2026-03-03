package tests;

import org.junit.jupiter.api.Test;
import test.data.RegistrationPage;
import test.data.TestDataGenerator;


public class TestAutomationPracticeForm extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void allFieldsFilledInTest() {
        TestDataGenerator testDataGenerator = new TestDataGenerator();
        TestDataGenerator.StudentData student = testDataGenerator.new StudentData();

        registrationPage.openPage()
                .setFirstName(student.firstName)
                .setLastName(student.lastName)
                .setEmail(student.email)
                .setGender(student.gender)
                .setNumber(student.phoneNumber)
                .setBirthDate(student.birthYear, student.birthMonth, student.birthDay)
                .setSubjects(student.subjects)
                .setHobbies(student.hobbies)
                .uploadPicture(student.uploadPicture)
                .setCurrentAddress(student.currentAddress)
                .setState(student.state)
                .setCity(student.city)
                .clickSubmit();

        registrationPage.checkSuccessModalAppears()
                .getResultTable()
                .checkStudentName(student.firstName, student.lastName)
                .checkStudentEmail(student.email)
                .checkGender(student.gender)
                .checkMobile(student.phoneNumber)
                .checkDateOfBirth(student.dateOfBirth)
                .checkSubjects(student.subjects)
                .checkHobbies(student.hobbies)
                .checkPicture(student.uploadPicture)
                .checkAddress(student.currentAddress)
                .checkStateAndCity(student.state, student.city);
    }

    @Test
    void requiredFieldsOnlyTest() {
        TestDataGenerator testDataGenerator = new TestDataGenerator();
        TestDataGenerator.StudentData student = testDataGenerator.new StudentData();

        registrationPage.openPage()
                .setFirstName(student.firstName)
                .setLastName(student.lastName)
                .setGender(student.gender)
                .setNumber(student.phoneNumber)
                .scrollToSubmitAndClick();

        registrationPage.checkSuccessModalAppears()
                .getResultTable()
                .checkStudentName(student.firstName, student.lastName)
                .checkGender(student.gender)
                .checkMobile(student.phoneNumber);
    }
}