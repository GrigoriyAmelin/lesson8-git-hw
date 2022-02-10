package junit;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeAll
    static void before() {
        System.out.println("This method is done before all tests");
    }

    @AfterAll
    static void after() {
        System.out.println("This method is done after all tests");
    }

    @BeforeEach
    void openBrowser() {
        System.out.println("This method is done before each tests");
    }

    @AfterEach
    void closeBrowser(){
        System.out.println("This method is done after each tests");
        System.out.println();
    }

    @Test
    void textTest() {
        // search text
        System.out.println("This is first test");
        Assertions.assertTrue(2<3);
    }

    @Test
    void videoTest() {
        // search video
        System.out.println("This is second test");
        Assertions.assertTrue(5>3);
    }
}
