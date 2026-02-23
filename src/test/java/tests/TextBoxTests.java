package tests;


import test.data.TestData;
import org.junit.jupiter.api.Test;
import test.data.TextBoxPage;

import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("");

        new TextBoxPage()
                .openElementsSection()
                .openTextBoxPage()
                .fillAllFields(TestData.USER_NAME, TestData.USER_EMAIL,
                        TestData.CURRENT_ADDRESS, TestData.PERMANENT_ADDRESS)
                .clickSubmit()
                .verifyAllFields(TestData.USER_NAME, TestData.USER_EMAIL,
                        TestData.CURRENT_ADDRESS, TestData.PERMANENT_ADDRESS);
    }

    @Test
    void successfulFillFormWithoutAddressTest() {
        open("");

        new TextBoxPage()
                .openElementsSection()
                .openTextBoxPage()
                .fillRequiredFields(TestData.USER_NAME, TestData.USER_EMAIL)
                .clickSubmit()
                .verifyRequiredFields(TestData.USER_NAME, TestData.USER_EMAIL);
    }
}