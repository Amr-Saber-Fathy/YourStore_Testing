package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestChangeCurrency extends TestBase{

    HomePage homePage;

    @Test
    public void TestDollarCurrency(){
        homePage = new HomePage(driver);
        homePage.changeCurrency("dollar");

        Assert.assertTrue(homePage.currencyButton.getText().contains("$"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void TestEuroCurrency(){
        homePage = new HomePage(driver);
        homePage.changeCurrency("euro");

        Assert.assertTrue(homePage.currencyButton.getText().contains("€"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void TestPoundCurrency(){
        homePage = new HomePage(driver);
        homePage.changeCurrency("pound");

        Assert.assertTrue(homePage.currencyButton.getText().contains("£"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
