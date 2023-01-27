package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    public static WebDriver driver;

    /***repozytorium elementów***/
    @FindBy (css = "li>a[@href='http://www.selenium-shop.pl/sklep/']")
    WebElement shopMenu;
    @FindBy (linkText = "MOJE KONTO")
    WebElement myAccountMenu;

    /***konstruktor***/
    public HomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /***metody***/
    //przejście na stronę sklepu z produktami
    public ProductListPage goToProductPage() {
       shopMenu.click();
       return new ProductListPage();
    }

    //przejście na stronę Moje konto (logowanie)
    public LoginPage goToLoginPage() {
        myAccountMenu.click();
        return new LoginPage();
    }
}
