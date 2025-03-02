package main;

import factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainPage_Test {
    private static WebDriverFactory webDriverFactory = new WebDriverFactory();

   private WebDriver driver = null;


    @BeforeAll
    public static void init() {
        webDriverFactory.webDriverManagerSetup();
    }

    @BeforeEach
    public void createDriver() {
        driver = webDriverFactory.create();
    }
}

