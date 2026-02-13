package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase{
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
