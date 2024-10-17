package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends PageBase{


    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]")
    WebElement myAccountButton;

    @FindBy(linkText = "Register")
    WebElement registrationButton;

    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/button")
    public WebElement currencyButton;

    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[1]/button")
    WebElement euroButton;

    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[2]/button")
    WebElement poundButton;

    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[3]/button")
    WebElement dollarButton;

    public void openRegistrationPage(){
        clickButton(myAccountButton);
        waitForElement(registrationButton);
        clickButton(registrationButton);
    }

    public void changeCurrency(String currencyType){
        clickButton(currencyButton);
        switch (currencyType.toLowerCase()){
            case "dollar":
                waitForElement(dollarButton);
                clickButton(dollarButton);
                break;
            case "euro":
                waitForElement(euroButton);
                clickButton(euroButton);
                break;
            case "pound":
                waitForElement(poundButton);
                clickButton(poundButton);
                break;
            default:
                System.out.println("Invalid Currency");
        }
    }
}
