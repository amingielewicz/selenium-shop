package test;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AddressPage;
import pages.HomePage;
import pages.LoginPage;

public class AddressPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;

    /********* konstruktor ***********/
    public AddressPageTest() {
        super();
    }

    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        addressPage = new AddressPage();

        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
        addressPage = accountPage.goToAddress();
    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    /*********  TESTY *********/
    @Test(priority = 1)
    public void verifyNoDeliveryAddress() {
        Assert.assertFalse(addressPage.getInfoDeliveryAddress().equalsIgnoreCase(testdata.getProperty("correctInfoAboutDeliveryAddress")));

        takeScreenshot(4);

    }
}
