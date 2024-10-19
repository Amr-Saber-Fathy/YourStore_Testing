package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.FakerDataGenerator;

public class TestUserRegistration extends TestBase{

    static HomePage homePage;
    static RegistrationPage registrationPage;
    static LoginPage loginPage;

    String userEmail;
    /****************DataProvider with FakeData Generator*******************/
    @DataProvider(name = "registrationData")
    public Object[][] createData() {
        userEmail = FakerDataGenerator.getRandomEmail();
        return new Object[][] { {FakerDataGenerator.getRandomFirstName(), FakerDataGenerator.getRandomLastName(),
                userEmail, FakerDataGenerator.getRandomPhone(), "Test123456"}};
    }

    @DataProvider(name = "loginData")
    public Object[][] createLoginData() {
        return new Object[][] { {userEmail, "Test123456"}};
    }

    /*****************Verify that user can Register new account***********************/
    @Test(dataProvider = "registrationData")
    public void userRegisterSuccessfully(String firstName, String lastName, String email, String phone, String password){
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();

        registrationPage = new RegistrationPage(driver);
        registrationPage.registerWithNoSubscribe(firstName, lastName, email, phone, password);

        Assert.assertTrue(registrationPage.getConfirmationMessage().contains("Your Account Has Been Created!"));

        homePage.logOut();//LogOut

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(dataProvider = "loginData", dependsOnMethods = {"userRegisterSuccessfully"})
    public void registeredUserCanLogin(String email, String password){
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);

        loginPage.login(email, password);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
