package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TestUserLogin extends TestBase{

    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void userLogin(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        homePage.openLoginPage();
        loginPage.login("amr.saber.fathy2@gmail.com", "Test123456");
    }
}
