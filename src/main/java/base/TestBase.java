package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import static java.lang.Integer.*;

public class TestBase {
    public static Properties config;
    public static WebDriver driver;
    public static WebDriver driver1;
    public static WebDriverWait wait;
    public static Properties testdata;


    public TestBase(){
    try {
        config = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                "/src/main/java/config/config.properties");
        config.load(file);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    try {
            testdata = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/testdata/testdata.properties");
            testdata.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chromedriver", System.getProperty("user.dir") +
                        "/src/main/resources/chromedriver");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                ChromeDriver driver = new ChromeDriver(options);

                break;
            case "firefox":
                System.setProperty("webdriver.geckodriver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");

                FirefoxDriver driver1 = new FirefoxDriver();
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
        }
    }


