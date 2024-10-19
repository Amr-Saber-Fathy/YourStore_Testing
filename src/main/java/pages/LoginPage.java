package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageBase{


    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /*************Locators*************/
    @FindBy(css = "input#input-email.form-control")
    WebElement emailField;

    @FindBy(css = "input#input-password.form-control")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")
    WebElement forgottenPasswordLink;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input[1]")
    WebElement loginBtn;

    /*************Methods*************/
    public void login(String email, String password){
        waitTime(5);
        sendTextBoxText(emailField, email);
        sendTextBoxText(passwordField, password);
        clickButton(loginBtn);
    }
}
