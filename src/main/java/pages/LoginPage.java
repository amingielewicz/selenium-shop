package pages;

import base.TestBase;
import helpers.GlobalMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends TestBase {
    GlobalMethods globalMethods;

    /*** repozytorium elementów ***/
    @FindBy(id = "username")
    WebElement loginInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(css = "button[name='login']")
    WebElement loginButton;

    /*** konstruktor ***/
    public LoginPage() {
        globalMethods = new GlobalMethods();
//        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*** metody ***/
//    //pobranie i zwrócenie aktualnego tytułu strony
//    public String getPageTitle() {
//        String title = driver.getTitle();
//        System.out.println("Tytuł strony to: "+ driver.getTitle());
//        return title;
//    }
//    //Wypełnienie pola login
//    public void setLoginInput(String login) {
//        wait.until(visibilityOf(passwordInput));
//        loginInput.clear();
//        loginInput.sendKeys(login);
//    }
//    //Wypełnienie pola hasło.
//    public void setPasswordInput(String password) {
//        wait.until(visibilityOf(passwordInput));
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
//    }
//    //Metoda klikająca przycisk zaloguj.
//    public void clickLoginButton() {
//        wait.until(visibilityOf(loginButton));
//        loginButton.click();
//    }
//
//    //metoda zbiorcza trzech metod powyżej. Wywołujemy te metody.
    // Metoda wykonująca pełną akcję logowania
    //zwracająca stronę AccountPage
    public AccountPage login(String login, String password){
//        setLoginInput(login);
//        setPasswordInput(password);
//        clickLoginButton();
        globalMethods.setInput(loginInput, login);
        globalMethods.setInput(passwordInput, password);
        globalMethods.clickButton(loginButton);
        return new AccountPage();
    }
}
