package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainPage extends AbsBasePage {
    public MainPage(WebDriver driver) {
        super(driver, "/training.html");
    }

    private By textInputSelector = By.id("textInput");
    private String textForTextInput = "ОТУС";
    private By modalButtonSelector = By.id("openModalBtn");
    String nameUsers = "otus";
    String emailUsers = "otus@test.ru";
    private By nameSelector = By.id("name");
    private By emailSelector = By.id("email");
    //private By submitSelector= By.xpath("//button[@type='submit']");
    private By submitSelector= By.cssSelector("button[type='submit']");
    private By messageBox = By.id("messageBox");

    public void enterTextInTextInput() {
        driver.findElement(textInputSelector).sendKeys(textForTextInput);
    }
    public void enterTextInTextInputShouldBeSameAs () {
       WebElement elementTextInput = driver.findElement(textInputSelector);
       Assertions.assertEquals(textForTextInput,elementTextInput.getAttribute("value"));
    }

    public void clickPopUp() {
        driver.findElement(modalButtonSelector).click();
    }
    public void checkPopupIsDisplayed() {
        driver.findElement(modalButtonSelector).isDisplayed();
    }
    public void sendNameUsersInTextInput() {
    driver.findElement(nameSelector).sendKeys(nameUsers);
    }
    public void sendEmailUsersInTextInput() {
        driver.findElement(emailSelector).sendKeys(emailUsers);
    }
    public void clickSubmit() {
        driver.findElement(submitSelector).click();
    }
    public void checkDynamicForm() {
        Assertions.assertEquals("Форма отправлена с именем: otus и email: otus@test.ru", driver.findElement(messageBox).getText());

    }
}
