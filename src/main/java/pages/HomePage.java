package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class HomePage extends TestBase {    //extends - HomePage będzie mogło korzystać z TestBase
    //nie musimy podawać inicjalizacji WebDrivera czy WebDriverWait bo podaliśmy w TestBase

    /***repozytorium elementów***/
    @FindBy (css = "li>a[@href='http://www.selenium-shop.pl/sklep/']")
    private WebElement shopMenu;
    @FindBy (linkText = "MOJE KONTO")
    private WebElement myAccountMenu;

    /***konstruktor***/
    public HomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /***metody***/
    //przejście na stronę sklepu z produktami
    public ProductListPage goToProductPage() {
        wait.until(visibilityOf(shopMenu)); //czekanie czy ta opcja jest widoczna
       shopMenu.click();
       return new ProductListPage();
    }

    //przejście na stronę Moje konto (logowanie)
    public LoginPage goToLoginPage() {
        wait.until(visibilityOf(myAccountMenu));
        myAccountMenu.click();
        return new LoginPage();
    }
}
