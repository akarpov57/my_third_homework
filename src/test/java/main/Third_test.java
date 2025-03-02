package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;

public class Third_test {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(Third_test.class);

    @BeforeEach
    public void setUpOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        if (driver != null)
            driver.close();
    }

    @Test
    @DisplayName("Третий тест")
    public void checkDynamicForm() {

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.sendNameUsersInTextInput();
        mainPage.sendEmailUsersInTextInput();
        mainPage.clickSubmit();
        mainPage.checkDynamicForm();
        logger.info("Тест #3 пройден");
    }
}
