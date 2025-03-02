package factory;

import exceptions.BrowserNotSupportedException;
import factory.settings.ChromeSettings;
import factory.settings.FirefoxSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    private String browser = System.getProperty("browser");

    //верно
    public WebDriver create() {
        switch (browser) {
            case "chrome": {
                return new ChromeDriver((ChromeOptions) new ChromeSettings().settings());
            }
            case "firefox": {
                return new FirefoxDriver((FirefoxOptions) new FirefoxSettings().settings());
            }
        }
        throw new BrowserNotSupportedException(browser);
    }

    public void webDriverManagerSetup() {
        switch (browser) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                break;
            }
            default: {
                throw new BrowserNotSupportedException(browser);
            }
        }

    }
}
