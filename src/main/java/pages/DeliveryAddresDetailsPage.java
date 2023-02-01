package pages;

import base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class DeliveryAddresDetailsPage extends TestBase {

    /*** repozytorium elementów ***/


    /*** konstruktor ***/
    public DeliveryAddresDetailsPage() {
        PageFactory.initElements(driver, this);

        /****  metody  ****/

        //Wpisanie wartości tekstowej w pole Imię

        //Wpisanie wartości tekstowej w pole Nazwisko
        //Wpisanie wartości tekstowej w pole Region
        //Wpisanie wartości tekstowej w pole Ulica
        //Wpisanie wartości tekstowej w pole Kod pocztowy
        //Wpisanie wartości tekstowej w pole Miasto
        //Kliknięcie przycisku: Zapisz adres

        //Metoda wykinująca pełną akcję uzupełnienie formularza adresy dostawy
        //zwraca stronę AddressPage

    }
}
