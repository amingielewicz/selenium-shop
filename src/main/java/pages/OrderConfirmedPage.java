package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class OrderConfirmedPage extends TestBase {

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-content']/div[2]")
    private WebElement infoAboutOrders;


    /**** konstruktor ****/
    public OrderConfirmedPage() {
        //globalMethods = new GlobalMethods();
        PageFactory.initElements(driver, this);
    }

    /****  metody  ****/
    // Pobranie i zwrócenie komunikatu o liczbie złożonych zamówień
    public String getInfoAboutOrders() {
        wait.until(visibilityOf(infoAboutOrders));
        String message = infoAboutOrders.getText();
        System.out.println("Komunikat dotyczący ilośc złożonych zamówień: " + message);
        return message;
        //  return globalMethods.getTextFromElement(infoAboutOrders);
    }

}

