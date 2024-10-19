package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;
    public WebDriverWait wait;
    public Select select;
    public Actions action;

    public PageBase(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickButton(WebElement button){
        button.click();
    }

    public void sendTextBoxText(WebElement txtBox, String text){
        txtBox.sendKeys(text);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void waitForElement(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitTime(long time)
    {
        wait.withTimeout(Duration.ofSeconds(time));
    }
}
