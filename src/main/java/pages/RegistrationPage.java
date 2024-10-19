package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase{


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    /*************Locators*************/
    @FindBy(id = "input-firstname")
    WebElement firstNameTextField;

    @FindBy(id = "input-lastname")
    WebElement lastNameTextField;

    @FindBy(id = "input-email")
    WebElement emailTextField;

    @FindBy(id = "input-telephone")
    WebElement telephoneTextField;

    @FindBy(id = "input-password")
    WebElement passwordTextField;

    @FindBy(id = "input-confirm")
    WebElement confirmPasswordTextField;

    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
    WebElement subscribeYesRadioBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    WebElement agreePolicyCheckBox;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    WebElement confirmationMessage;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
    WebElement confirmationContinueBtn;

    /*************Methods*************/
    public void registerWithNoSubscribe(String firstName, String lastName, String email, String phone, String password){

        sendTextBoxText(firstNameTextField, firstName);
        sendTextBoxText(lastNameTextField, lastName);
        sendTextBoxText(emailTextField, email);
        sendTextBoxText(telephoneTextField, phone);
        sendTextBoxText(passwordTextField, password);
        sendTextBoxText(confirmPasswordTextField, password);

        clickButton(agreePolicyCheckBox);
        clickButton(continueBtn);
    }

    public void registerWithSubscribe(String firstName, String lastName, String email, String phone, String password){

        sendTextBoxText(firstNameTextField, firstName);
        sendTextBoxText(lastNameTextField, lastName);
        sendTextBoxText(emailTextField, email);
        sendTextBoxText(telephoneTextField, phone);
        sendTextBoxText(passwordTextField, password);
        sendTextBoxText(confirmPasswordTextField, password);

        clickButton(subscribeYesRadioBtn);
        clickButton(agreePolicyCheckBox);
        clickButton(continueBtn);
    }

    public String getConfirmationMessage(){
        String message = getText(confirmationMessage);
        clickButton(confirmationContinueBtn);
        return message;
    }
}
