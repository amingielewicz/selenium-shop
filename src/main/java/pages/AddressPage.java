package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AddressPage extends TestBase {

    /*** repozytorium elementów ***/
    @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*//parent::*/address")
    private WebElement infoDeliveryAddress;
    @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*/a")
    private WebElement addDeliveryAddress;

    /*** konstruktor ***/
    public AddressPage() {
        PageFactory.initElements(driver, this);
    }
    /****  metody  ****/
    // Przejście do strony z dodaniem/edytowaniem adresy dostawy
    public DeliveryAddresDetailsPage goToAddDeliveryAddress(){
        wait.until(visibilityOf(addDeliveryAddress));
        addDeliveryAddress.click();
        return new DeliveryAddresDetailsPage();
    }
    // Pobranie i zwrócenie komunikatu dotyczącego istnienia adresy dostawy
    public String getInfoDeliveryAddress(){
        wait.until(visibilityOf(infoDeliveryAddress));
        String message = infoDeliveryAddress.getText();
        System.out.println("Komunikat adres dostawy: "+ message);
        return message;
    }
}
