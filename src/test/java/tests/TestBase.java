package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browserName"})
    public void startDriver(@Optional("chrome") String browserType)
    {
        System.out.println("Running browser is : " + browserType);

        if(browserType.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browserType.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
    }

    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }
}
