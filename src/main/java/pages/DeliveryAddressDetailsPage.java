package pages;

import base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class DeliveryAddressDetailsPage extends TestBase {

    /*** repozytorium elementów ***/
    @FindBy(css = "input#shipping_first_name")
    private WebElement nameInput;
    @FindBy(css = "input#shipping_last_name")
    private WebElement lastNameInput;
    @FindBy(css = "span.select2-selection__arrow")
    private WebElement countryInputArrow;
    @FindBy(css = "input.select2-search__field")
    private WebElement countryInput;
    @FindBy(css = "input#shipping_address_1")
    private WebElement streetInput;
    @FindBy(css = "input#shipping_city")
    private WebElement cityInput;
    @FindBy(css = "input#shipping_state")
    private WebElement regionInput;
    @FindBy(css = "input#shipping_postcode")
    private WebElement postCodeInput;
    @FindBy(css = "button.button")
    private WebElement saveButton;


    /*** konstruktor ***/
    public DeliveryAddressDetailsPage() {
        PageFactory.initElements(driver, this);

        /****  metody  ****/
        //Wpisanie wartości tekstowej w pole Imię
        public void setName (String nameStr){
            wait.until(visibilityOf(nameInput));
            nameInput.clear();
            nameInput.sendKeys(nameStr);
        }
        //Wpisanie wartości tekstowej w pole Nazwisko
        public void setLastName (String lastNameStr){
            wait.until(visibilityOf(lastNameInput));
            lastNameInput.clear();
            lastNameInput.sendKeys(lastNameStr);
        }
        //Wpisanie wartości tekstowej w pole Region
        public void setCountry (String countryStr){
            wait.until(visibilityOf(countryInputArrow));
            countryInputArrow.click();
            countryInput.sendKeys(countrySr, Keys.ENTER);
        }
        //Wpisanie wartości tekstowej w pole Ulica
        public void setStreet (String streetStr){
            wait.until(visibilityOf(streetInput));
            streetInput.clear();
            streetInput.sendKeys(streetStr);
        }
        //Wpisanie wartości tekstowej w pole Miasto
        public void setCity (String cityStr){
            wait.until(visibilityOf(cityInput));
            cityInput.clear();
            cityInput.sendKeys(cityStr);
        }
        //Wpisanie wartości tekstowej w pole Województwo
        public void setCity (String regionStr){
            wait.until(visibilityOf(regionInput));
            regionInput.clear();
            regionInput.sendKeys(regionStr);
        }
        //Wpisanie wartości tekstowej w pole Kod pocztowy
        public void setPostCode (String postCodeStr){
            wait.until(visibilityOf(postCodeInput));
            postCodeInput.clear();
            postCodeInput.sendKeys(postCodeStr);
        }
        //Kliknięcie przycisku: Zapisz adres
        public void clickInSaveButton () {
            wait.until(visibilityOf(saveButton));
            saveButton.click();
        }
        //Metoda wykinująca pełną akcję uzupełnienie formularza adresy dostawy
        //zwraca stronę AddressPage
        public AddressPage fillF orm (String nameStr, String lastNameStr, String countryStr, String addressStr, String
        postCodeStr, String cityStr){
            setName(nameStr);
            setLastName(lastNameStr);
            setCountry(countryStr);
            setCity(cityStr);
            setStreet(streetStr);
            setPostCode(postCodeStr);
            clickInSaveButton();
            return new AddressPage();
        }


    }
}
