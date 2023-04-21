package reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.xml.XmlSuite;


public class ExtentReporter2 implements IReporter {

    public WebDriver driver;
    public ExtentSparkReporter spark;
    public ExtentReports extent;
    public ExtentTest logger;

    @BeforeTest
    public void startReport(List<XmlSuite> xmlSuiteList, List<ISuite> suites,
                            String outputDirectory) {

        // Create an object of Extent Reports
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(outputDirectory + File.separator + "/home/amingielewicz/IdeaProjects/selenium-shop/reports");
        extent.attachReporter(spark);
        extent.setSystemInfo("Host Name", "SoftwareTesting0");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("User Name", "STestngo");
        spark.config().setDocumentTitle("Title of the Report Comes here ");
        // Name of the report
        spark.config().setReportName("Name of the Report Comes here ");
        // Dark Theme
        spark.config().setTheme(Theme.STANDARD);

    }

    //This method is to capture the screenshot and return the path of the screenshot.
    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://AutomationFramework//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void verifyTitle() {
        logger = extent.createTest("To verify Google Title");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void verifyLogo() {
        logger = extent.createTest("To verify Google Logo");
        boolean img = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
        logger.createNode("Image is Present");
        Assert.assertTrue(img);
        logger.createNode("Image is not Present");
        Assert.assertFalse(img);
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            //MarkupHelper is used to display the output in different colors
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
            //String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
            String screenshotPath = getScreenShot(driver, result.getName());
            //To add it in the extent report
            logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        }
        driver.quit();
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }
}

