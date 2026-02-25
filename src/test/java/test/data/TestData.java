package test.data;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class TestData {

    private static final Faker faker = new Faker(new Locale("en"));
    private static final Random random = new Random();

    // Генерация основных данных
    public static final String FIRST_NAME = faker.name().firstName();
    public static final String LAST_NAME = faker.name().lastName();
    public static final String USER_NAME = FIRST_NAME + " " + LAST_NAME;
    public static final String USER_EMAIL = faker.internet().emailAddress();

    // Генерация гендера
    public static final String GENDER = getRandomGender();

    // Генерация номера телефона (10 цифр)
    public static final String USER_NUMBER = faker.phoneNumber().subscriberNumber(10);

    // Генерация предметов
    public static final String SUBJECTS = getRandomSubject();

    // Генерация хобби
    public static final String HOBBIES = getRandomHobby();

    // Генерация файла (можно оставить статичным или создать список)
    public static final String UPLOAD_PICTURE = "176061-yablochnyj_pejzazh-yabloko-illustracia-prirodnyj_landshaft-purpur-500x.jpg";

    // Генерация адресов
    public static final String CURRENT_ADDRESS = faker.address().fullAddress();
    public static final String PERMANENT_ADDRESS = faker.address().fullAddress();

    // Генерация штата и города
    public static final String STATE = getRandomState();
    public static final String CITY = getRandomCity(STATE);

    // Генерация даты рождения
    private static final LocalDate birthDate = generateRandomBirthDate();
    public static final String BIRTH_YEAR = String.valueOf(birthDate.getYear());
    public static final String BIRTH_MONTH = String.valueOf(birthDate.getMonthValue() - 1); // Для календаря (0-based)
    public static final String BIRTH_DAY = String.format("%03d", birthDate.getDayOfMonth());
    public static final String DATE_OF_BIRTH = birthDate.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH));

    // Методы для генерации случайных значений
    private static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return genders[random.nextInt(genders.length)];
    }

    private static String getRandomSubject() {
        String[] subjects = {"Math", "Physics", "Chemistry", "Biology", "Computer Science",
                "Commerce", "Economics", "Arts", "Social Studies", "History",
                "Civics", "Hindi", "English"};
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
        // Генерация даты рождения от 18 до 65 лет
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