package tests.examples;

import org.junit.jupiter.api.*;

public class JUnitExamplesTests {
    @BeforeAll
    static void startup() {
        //
        System.out.println("Tests startup");
    }
    @AfterAll
    static void teardown() {
        //
        System.out.println("Tests ended");
    }
    @BeforeEach
    void startBrowser() {
        // Code to start a browser
        System.out.println("- Browser started");
    }
    @AfterEach
    void stopBrowser() {
        // Code to start a browser
        System.out.println("- Browser stopped");
    }
    @Test
    void firstTest() {
        // Test code here
        System.out.println("- - Running first test");
    }
    @Test
    void secondTest() {
        // Test code here
        System.out.println("- - Running second test");
    }
}
