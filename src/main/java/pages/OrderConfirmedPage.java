package pages;

import base.TestBase;
import org.openqa.selenium.support.PageFactory;

import static base.TestBase.driver;

public class OrderConfirmedPage extends TestBase {
    /*** repozytorium elementów ***/




    /*** konstruktor ***/
    public OrderConfirmedPage() {
        PageFactory.initElements(driver, this);
    }

    /*** metody ***/

    //Pobranie i zwrócenie komunikatu o liczbie złożonych zamówień
}
