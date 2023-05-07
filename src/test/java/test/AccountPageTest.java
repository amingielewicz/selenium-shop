package test;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class AccountPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;

    /********* konstruktor ***********/
    public AccountPageTest() {
        super();
    }

    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    /*********  TESTY *********/
    @Test(priority = 0)
    public void verifyNameAccountAfterLogin() {
        Assert.assertEquals(accountPage.getNameAccount(), testdata.getProperty("correctNameAccount"),
                "Nie jesteś zalogowany na własciwe konto! Proszę o wylogowanie się");
        takeScreenshot(2);

    }
}
