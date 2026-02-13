package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase{
    String userName;
    String userEmail;
    String currentAddress;
    String permanentAddress;
//
    @BeforeEach
   public void setup() {
//        userName = getRandomString(10);
        String userName = "Alex D";
        String userEmail = "Alex@ya.com";
        String currentAddress = "first address 1";
        String permanentAddress = "second address 2";
   }
@Test
    void succesfulFillFormTest() {
    //        String userName = "Alex D";
    //        String userEmail = "Alex@ya.com";
    //        String currentAddress = "first address 1";
    //        String permanentAddress = "second address 2";
    open("/text-box");
    $("[id=userName]").setValue("userName");
    $("[id=userEmail]").setValue("userEmail");
    $("[id=currentAddress]").setValue("currentAddress");
    $("[id=permanentAddress]").setValue("permanentAddress");
    $("[id=submit]").click();

    $("[id=output] [id=name]").shouldHave(text("userName"));
    $("[id=output] [id=email]").shouldHave(text("userEmail"));
    $("[id=output] [id=currentAddress]").shouldHave(text("currentAddress"));
    $("[id=output] [id=permanentAddress]").shouldHave(text("permanentAddress"));
}
        @Test
    void successfulFillFormWithoutAddressTest(){
        //        String userName = "Alex D";
        //        String userEmail = "Alex@ya.com";

        open("/text-box");
        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue(userEmail);
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text(userName));
        $("[id=output] [id=email]").shouldHave(text(userEmail));
    }
}
