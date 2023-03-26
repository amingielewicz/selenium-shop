package helpers;

import base.TestBase;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GlobalMethods extends TestBase {

    public GlobalMethods(){}

    public String getPageTitle(){
        String title = driver.getTitle();
        System.out.println("Page title " + title);
        return title;
    }
    public void setInput(WebElement inputElement, String text){
        wait.until(visibilityOf(inputElement));
        inputElement.clear();
        inputElement.sendKeys(text);
    }
    public void clickButton(WebElement buttonElement){
        wait.until(elementToBeClickable(buttonElement)).click();
    }
    public String getTextFromElement(WebElement element){
        wait.until(visibilityOf(element));
        String text = element.getText();
        return text;
    }
}
