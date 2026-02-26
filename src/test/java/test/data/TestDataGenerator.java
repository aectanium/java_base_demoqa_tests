package test.data;

import net.datafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class TestDataGenerator {

    private static final Faker faker = new Faker(new Locale("ru"));
    private static final Random random = new Random();

    public static class StudentData {
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
            this.phoneNumber = generatePhoneNumber();
            this.subjects = getRandomSubject();
            this.hobbies = getRandomHobby();
            this.uploadPicture = "176061-yablochnyj_pejzazh-yabloko-illustracia-prirodnyj_landshaft-purpur-500x.jpg";
            this.currentAddress = faker.address().fullAddress();
            this.state = getRandomState();
            this.city = getRandomCity(this.state);

            LocalDate birthDate = generateRandomBirthDate();
            this.birthYear = String.valueOf(birthDate.getYear());
            this.birthMonth = String.valueOf(birthDate.getMonthValue() - 1);
            this.birthDay = String.format("%03d", birthDate.getDayOfMonth());
            this.dateOfBirth = birthDate.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH));
        }
    }

    private static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return genders[random.nextInt(genders.length)];
    }

    private static String generatePhoneNumber() {

        StringBuilder phoneNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    private static String getRandomSubject() {
        String[] subjects = {
                "Math", "Physics", "Chemistry", "Biology", "Computer Science",
                "Commerce", "Economics", "Arts", "Social Studies", "History",
                "Civics", "Hindi", "English"
        };
        return subjects[random.nextInt(subjects.length)];
    }

    private static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return hobbies[random.nextInt(hobbies.length)];
    }

    private static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return states[random.nextInt(states.length)];
    }

    private static String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
                return ncrCities[random.nextInt(ncrCities.length)];
            case "Uttar Pradesh":
                String[] upCities = {"Agra", "Lucknow", "Merrut"};
                return upCities[random.nextInt(upCities.length)];
            case "Haryana":
                String[] haryanaCities = {"Karnal", "Panipat"};
                return haryanaCities[random.nextInt(haryanaCities.length)];
            case "Rajasthan":
                String[] rajasthanCities = {"Jaipur", "Jaiselmer"};
                return rajasthanCities[random.nextInt(rajasthanCities.length)];
            default:
                return "Delhi";
        }
    }

    private static LocalDate generateRandomBirthDate() {

        int minAge = 18;
        int maxAge = 65;
        LocalDate now = LocalDate.now();
        LocalDate minDate = now.minusYears(maxAge);
        LocalDate maxDate = now.minusYears(minAge);

        long minDay = minDate.toEpochDay();
        long maxDay = maxDate.toEpochDay();
        long randomDay = minDay + random.nextInt((int) (maxDay - minDay));

        return LocalDate.ofEpochDay(randomDay);
    }
}