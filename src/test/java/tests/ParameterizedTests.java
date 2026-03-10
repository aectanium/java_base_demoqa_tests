package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.Arguments;
import test.data.RegistrationPage;
import test.data.TestDataGenerator;
import java.util.stream.Stream;

public class ParameterizedTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();

    @ParameterizedTest
    @ValueSource(strings = {"Male", "Female", "Other"})
    @DisplayName("Test form with different genders")
    void testFormWithDifferentGenders(String gender) {
        TestDataGenerator testData = new TestDataGenerator();

        registrationPage.openPage()
                .fillForm(testData.firstName, testData.lastName, testData.userEmail,
                        gender, testData.userNumber, testData.dayOfBirth,
                        testData.monthOfBirth, testData.yearOfBirth, testData.subjects,
                        testData.hobbies, testData.picturePath, testData.currentAddress,
                        testData.state, testData.city)
                .checkResult("Gender", gender);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234567890", "9876543210", "5555555555", "1111111111"})
    @DisplayName("Test form with different phone numbers")
    void testFormWithDifferentPhoneNumbers(String phoneNumber) {
        TestDataGenerator testData = new TestDataGenerator();

        registrationPage.openPage()
                .fillForm(testData.firstName, testData.lastName, testData.userEmail,
                        testData.gender, phoneNumber, testData.dayOfBirth,
                        testData.monthOfBirth, testData.yearOfBirth, testData.subjects,
                        testData.hobbies, testData.picturePath, testData.currentAddress,
                        testData.state, testData.city)
                .checkResult("Mobile", phoneNumber);
    }

    @ParameterizedTest
    @CsvSource({
            "John, Doe, john.doe@example.com, Male, 1234567890",
            "Jane, Smith, jane.smith@example.com, Female, 0987654321",
            "Alex, Johnson, alex.johnson@example.com, Other, 5555555555",
            "Maria, Garcia, maria.garcia@example.com, Female, 7777777777"
    })
    @DisplayName("Test student registration with basic data")
    void testStudentRegistrationBasicData(String firstName, String lastName,
                                          String email, String gender, String mobile) {
        TestDataGenerator testData = new TestDataGenerator();

        registrationPage.openPage()
                .fillForm(firstName, lastName, email, gender, mobile,
                        testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth,
                        testData.subjects, testData.hobbies, testData.picturePath,
                        testData.currentAddress, testData.state, testData.city)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile);
    }

    @ParameterizedTest
    @CsvSource({
            "15, January, 1990",
            "20, March, 1995",
            "10, July, 2000",
            "05, December, 1985"
    })
    @DisplayName("Test form with different birth dates")
    void testFormWithDifferentBirthDates(String day, String month, String year) {
        TestDataGenerator testData = new TestDataGenerator();

        registrationPage.openPage()
                .fillForm(testData.firstName, testData.lastName, testData.userEmail,
                        testData.gender, testData.userNumber, day, month, year,
                        testData.subjects, testData.hobbies, testData.picturePath,
                        testData.currentAddress, testData.state, testData.city)
                .checkResult("Date of Birth", day + " " + month + "," + year);
    }

    @ParameterizedTest
    @MethodSource("provideStudentData")
    @DisplayName("Test student registration with method source")
    void testStudentRegistrationWithMethodSource(String firstName, String lastName,
                                                 String email, String gender, String mobile) {
        TestDataGenerator testData = new TestDataGenerator();

        registrationPage.openPage()
                .fillForm(firstName, lastName, email, gender, mobile,
                        testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth,
                        testData.subjects, testData.hobbies, testData.picturePath,
                        testData.currentAddress, testData.state, testData.city)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender);
    }

    static Stream<Arguments> provideStudentData() {
        return Stream.of(
                Arguments.of("Emma", "Watson", "emma@test.com", "Female", "9876543210"),
                Arguments.of("Tom", "Hardy", "tom@test.com", "Male", "8765432109"),
                Arguments.of("Chris", "Evans", "chris@test.com", "Male", "7654321098"),
                Arguments.of("Scarlett", "Johansson", "scarlett@test.com", "Female", "6543210987")
        );
    }

    enum Gender {
        MALE("Male"),
        FEMALE("Female"),
        OTHER("Other");

        private final String displayName;

        Gender(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    @ParameterizedTest
    @EnumSource(Gender.class)
    @DisplayName("Test form with all gender options from enum")
    void testFormWithGenderEnum(Gender gender) {
        TestDataGenerator testData = new TestDataGenerator();

        registrationPage.openPage()
                .fillForm(testData.firstName, testData.lastName, testData.userEmail,
                        gender.getDisplayName(), testData.userNumber, testData.dayOfBirth,
                        testData.monthOfBirth, testData.yearOfBirth, testData.subjects,
                        testData.hobbies, testData.picturePath, testData.currentAddress,
                        testData.state, testData.city)
                .checkResult("Gender", gender.getDisplayName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/student-data.csv", numLinesToSkip = 1)
    @DisplayName("Test student registration with data from CSV file")
    void testStudentRegistrationFromCsvFile(String firstName, String lastName, String email,
                                            String gender, String mobile) {
        TestDataGenerator testData = new TestDataGenerator();

        registrationPage.openPage()
                .fillForm(firstName, lastName, email, gender, mobile,
                        testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth,
                        testData.subjects, testData.hobbies, testData.picturePath,
                        testData.currentAddress, testData.state, testData.city)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile);
    }

    // Дополнительные тесты с другими параметрами
    @ParameterizedTest
    @ValueSource(strings = {"Maths", "Physics", "Chemistry", "Biology", "English", "History"})
    @DisplayName("Test form with different subjects")
    void testFormWithDifferentSubjects(String subject) {
        TestDataGenerator testData = new TestDataGenerator();

        registrationPage.openPage()
                .fillForm(testData.firstName, testData.lastName, testData.userEmail,
                        testData.gender, testData.userNumber, testData.dayOfBirth,
                        testData.monthOfBirth, testData.yearOfBirth, subject,
                        testData.hobbies, testData.picturePath, testData.currentAddress,
                        testData.state, testData.city)
                .checkResult("Subjects", subject);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Sports", "Reading", "Music"})
    @DisplayName("Test form with different hobbies")
    void testFormWithDifferentHobbies(String hobby) {
        TestDataGenerator testData = new TestDataGenerator();

        registrationPage.openPage()
                .fillForm(testData.firstName, testData.lastName, testData.userEmail,
                        testData.gender, testData.userNumber, testData.dayOfBirth,
                        testData.monthOfBirth, testData.yearOfBirth, testData.subjects,
                        hobby, testData.picturePath, testData.currentAddress,
                        testData.state, testData.city)
                .checkResult("Hobbies", hobby);
    }
}