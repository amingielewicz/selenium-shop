package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends TestBase {    //extends - HomePage będzie mogło korzystać z TestBase
    //nie musimy podawać inicjalizacji WebDrivera czy WebDriverWait bo podaliśmy w TestBase

    /***repozytorium elementów***/
    @FindBy(xpath = "//a[text()='Sklep']")
    public WebElement shopMenu;
    @FindBy(linkText = "MOJE KONTO")
    public WebElement myAccountMenu;

    /***konstruktor***/
    public HomePage() {
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
        wait.until(ExpectedConditions.visibilityOf(myAccountMenu));
        myAccountMenu.click();
        return new LoginPage();
    }
}
