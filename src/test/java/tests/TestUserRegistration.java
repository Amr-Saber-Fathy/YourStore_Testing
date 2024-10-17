package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class TestUserRegistration extends TestBase{

    HomePage homePage;

    @Test
    public void userRegisterSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
