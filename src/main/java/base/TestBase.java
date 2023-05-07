package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class TestBase {
    public static Properties config;
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties testdata;

    //Inicjalizacja pliku z ustawieniami
    public TestBase() {
        try {
            config = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/config/config.properties");
            config.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie znaleziono pliku.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            testdata = new Properties();
            FileInputStream file = new FileInputStream("/home/amingielewicz/IdeaProjects/selenium-shop/src/main/java/testdata/testdata.properties");
            testdata.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie znaleziono pliku.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initialization() {
        DesiredCapabilities capabilities;

        String url = config.getProperty("URL");
        String browser = config.getProperty("browser");
        String pageLoadTimeout = config.getProperty("pageLoadTimeout");
        String windowMaximize = config.getProperty("windowMaximize");
        String waitTimeout = config.getProperty("waitTimeout");
        String deleteAllCookies = config.getProperty("deleteAllCookies");
        String grid = config.getProperty("grid");


        switch (browser) {
            case "chrome":
//               System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
//                        "/src/main/resources/chromedriver");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
//                options.setCapability("browserVersion", "100");
//                options.setCapability("platformName", "Linux");
//                options.setCapability("se:name", "My simple test");
//                options.setCapability("se:sampleMetadata", "Sample metadata value");

                if (grid.equalsIgnoreCase("true")) {
                    try {

                        driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    driver = new ChromeDriver(options);
                }

                break;
            case "firefox":
                System.setProperty("webdriver.geckodriver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");

                FirefoxDriver optionsf = new FirefoxDriver();
                if (grid.equalsIgnoreCase("true")) {
                    try {

                        driver = new RemoteWebDriver(new URL("http://192.168.5.94:4444"), (Capabilities) optionsf);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {

                    driver = new FirefoxDriver();
                }
                break;
            default:
                throw new IllegalArgumentException("Nierozpoznano przeglądarki internetowej. " +
                        "Obsługiwane dostęþne opcje: Chrome, Firefox.");
        }

        if (deleteAllCookies.equalsIgnoreCase("true")) {
            driver.manage().deleteAllCookies(); //jeśli w config.properties ustawimy true to się to wykona.
        }
        if (windowMaximize.equalsIgnoreCase("true")) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void takeScreenshot(int nrTestu) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("src/main/resources" + nrTestu + "screenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public String getPageTitle() {
        String title = driver.getTitle();
        System.out.println("Page title " + title);
        return title;
    }

    public void setInput(WebElement inputElement, String text) {
        wait.until(visibilityOf(inputElement));
        inputElement.clear();
        inputElement.sendKeys(text);
    }

    public void clickButton(WebElement buttonElement) {
        wait.until(elementToBeClickable(buttonElement)).click();
    }

    public String getTextFromElement(WebElement element) {
        wait.until(visibilityOf(element));
//        String text = element.getText();
//        return text;
        return element.getText();
    }
}



