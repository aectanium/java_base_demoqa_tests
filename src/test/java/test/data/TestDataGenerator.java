package test.data;

import net.datafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TestDataGenerator {

    private final Faker faker = new Faker(new Locale("en"));

    public class StudentData {
        public final String firstName;
        public final String lastName;
        public final String email;
        public final String gender;
        public final String phoneNumber;
        public final String subjects;
        public final String hobbies;
        public final String uploadPicture;
        public final String currentAddress;
        public final String state;
        public final String city;
        public final String birthYear;
        public final String birthMonth;
        public final String birthDay;
        public final String dateOfBirth;

        public StudentData() {
            this.firstName = faker.name().firstName();
            this.lastName = faker.name().lastName();
            this.email = faker.internet().emailAddress();
            this.gender = getRandomGender();
            this.phoneNumber = faker.phoneNumber().subscriberNumber(10);
            this.subjects = getRandomSubject();
            this.hobbies = getRandomHobby();
            this.uploadPicture = "176061-yablochnyj_pejzazh-yabloko-illustracia-prirodnyj_landshaft-purpur-500x.jpg";
            this.currentAddress = faker.address().fullAddress();
            this.state = getRandomState();
            this.city = getRandomCity(this.state);

            LocalDate birthDate = generateRandomBirthDate();
            this.birthYear = String.valueOf(birthDate.getYear());
            this.birthMonth = String.valueOf(birthDate.getMonthValue() - 1); // 0-based для календаря
            this.birthDay = String.valueOf(birthDate.getDayOfMonth());
            this.dateOfBirth = birthDate.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH));
        }
    }

    private String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    private String getRandomSubject() {
        String[] subjects = {
                "Math", "Physics", "Chemistry", "Biology", "Computer Science",
                "Commerce", "Economics", "Arts", "Social Studies", "History",
                "Civics", "Hindi", "English"
        };
        return faker.options().option(subjects);
    }

    private String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    private String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(states);
    }

    private String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
                return faker.options().option(ncrCities);
            case "Uttar Pradesh":
                String[] upCities = {"Agra", "Lucknow", "Merrut"};
                return faker.options().option(upCities);
            case "Haryana":
                String[] haryanaCities = {"Karnal", "Panipat"};
                return faker.options().option(haryanaCities);
            case "Rajasthan":
                String[] rajasthanCities = {"Jaipur", "Jaiselmer"};
                return faker.options().option(rajasthanCities);
            default:
                return "Delhi";
        }
    }

    private LocalDate generateRandomBirthDate() {

        LocalDate now = LocalDate.now();
        LocalDate startDate = now.minusYears(65);  // 65 лет назад
        LocalDate endDate = now.minusYears(18);    // 18 лет назад


        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomEpochDay = faker.number().numberBetween(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomEpochDay);
    }
}