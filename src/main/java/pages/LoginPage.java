package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver driver;

    /*** repozytorium elementów ***/
    @FindBy(id = "username")
    WebElement loginInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(css = "button[name='login']")
    WebElement loginButton;

    /*** konstruktor ***/
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*** metody ***/
    //pobranie i zwrócenie aktualnego tytułu strony
    public String getPageTitle() {
        String title = driver.getTitle();
        System.out.println("Tytuł strony to: "+ driver.getTitle());
        return title;
    }
    //Wypełnienie pola login
    public void setLoginInput(String login) {
        loginInput.clear();
        loginInput.sendKeys(login);
    }
    //Wypełnienie pola hasło.
    public void setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    //Metoda klikająca przycisk zaloguj.
    public void clickLoginButton() {
        loginButton.click();
    }
}
