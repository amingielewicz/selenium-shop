package test;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderConfirmedPage;

public class OrderConfirmedPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    OrderConfirmedPage orderConfirmedPage;

    /********* konstruktor ***********/
    public OrderConfirmedPageTest() {
        super();
    }

    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        orderConfirmedPage = new OrderConfirmedPage();

        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
        accountPage.goToOrders();
    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    /*********  TESTY *********/
    @Test(priority = 0)
    public void verifyNoOrders() {
        Assert.assertTrue(orderConfirmedPage.getInfoAboutOrders().contains(testdata.getProperty("correctInfoAboutOrder")),
                "Istnieją już złożone zamówienia!");

    }
}
