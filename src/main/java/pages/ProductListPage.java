package pages;

import base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage extends TestBase {

    /*** repozytorium elementów ***/




    /*** konstruktor ***/
    public ProductListPage() {
        PageFactory.initElements(driver, this);
    }

    /*** metody ***/

    //Pobieranie i zwrócenie ilości produktów

    //Wybranie z listy sortującej, pozycji: Sortuj wg ceny: od najniższej

    //Sortowanie listy po cenie od najniższej
    //pobieranie przesortowanej listy produktów
    //Wypisywanie produktów do konsoli
}
