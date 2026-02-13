package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize ="1920x1080";
        Configuration.browser = "chrome";
        Configuration.browserVersion ="144.0.7559.133";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }
    @Test
    void succesfulFillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("Alex D");
        $("[id=userEmail]").setValue("Alex@ya.com");
        $("[id=currentAddress]").setValue("first adress 1");
        $("[id=permanentAddress]").setValue("second adress 2");
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("Alex D"));
        $("[id=output] [id=email]").shouldHave(text("Alex@ya.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("first adress 1"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("second adress 2"));



    }
}
