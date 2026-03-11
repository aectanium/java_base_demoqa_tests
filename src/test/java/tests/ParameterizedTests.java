package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import test.data.Gender;
import test.data.RegistrationPage;
import test.data.TestDataGenerator;


public class ParameterizedTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();


    @ParameterizedTest
    @ValueSource(strings = {"Male", "Female", "Other"})
    @DisplayName("Тест формы с разным Gender")
    void testFormWithDifferentGenders(String gender) {
        TestDataGenerator generator = new TestDataGenerator();
        TestDataGenerator.StudentData testData = generator.new StudentData();

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(gender)
                .setNumber(testData.phoneNumber)
                .setBirthDate(testData.birthYear, testData.birthMonth, testData.birthDay)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .uploadPicture(testData.uploadPicture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .scrollToSubmitAndClick()
                .checkSuccessModalAppears()
                .getResultTable().checkResult("Gender", gender);

    }

    @ParameterizedTest
    @EnumSource(Gender.class)
    @DisplayName("Тест формы с разным Gender enum")
    void testFormWithGenderEnum(Gender gender) {
        TestDataGenerator generator = new TestDataGenerator();
        TestDataGenerator.StudentData testData = generator.new StudentData();

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(gender.getDisplayName())
                .setNumber(testData.phoneNumber)
                .setBirthDate(testData.birthYear, testData.birthMonth, testData.birthDay)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .uploadPicture(testData.uploadPicture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .scrollToSubmitAndClick()
                .checkSuccessModalAppears()
                .getResultTable().checkResult("Gender", gender.getDisplayName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/student-data.csv", numLinesToSkip = 1)
    @DisplayName("Тест с данными из CSV файла")
    void testFormWithCsvFileSource(String firstName, String lastName, String email,
                                   String gender, String mobile) {
        TestDataGenerator generator = new TestDataGenerator();
        TestDataGenerator.StudentData testData = generator.new StudentData();

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(mobile)
                .setBirthDate(testData.birthYear, testData.birthMonth, testData.birthDay)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .uploadPicture(testData.uploadPicture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .scrollToSubmitAndClick()
                .checkSuccessModalAppears()
                .getResultTable().checkResult("Gender", gender);
    }
}