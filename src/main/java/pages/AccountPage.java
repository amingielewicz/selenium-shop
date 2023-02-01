package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AccountPage extends TestBase {

    /*** repozytorium elementów ***/
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-content']/p/strong")
    private WebElement nameAccountLabel;
    @FindBy(xpath = "//a[contains()text,'Zamówienia']")
    private WebElement zamowieniaMenuBoczne;
    @FindBy(xpath = "//a[contains()text,'Adresy']")
    private WebElement adresyMenuBoczne;

    /*** konstruktor ***/
    public AccountPage() { PageFactory.initElements(driver, this); }

    /*** metody ***/
    //Pobranie i zwrócenie nazwy konta (Imię i nazwisko)
    public String getNameAccount(){
        wait.until(visibilityOf(nameAccountLabel));
        String nameAccount = nameAccountLabel.getText();
        System.out.println("Jesteś zalogowany jako: "+ nameAccount);
        return nameAccount;
    }
    //Przejście na zakładkę Zakówienia (zamówienia potwierdzone)
    public OrderConfirmedPage goToOrders(){
        wait.until(visibilityOf(zamowieniaMenuBoczne));
        zamowieniaMenuBoczne.click();
        return new OrderConfirmedPage();
    }
    //Przejście na zakładkę adresy
    public AdressPage goToAdress(){
        wait.until(visibilityOf(adresyMenuBoczne));
        adresyMenuBoczne.click();
        return new AdressPage();
    }
}
