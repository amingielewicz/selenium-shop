package reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentReporter implements IReporter {
    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuiteList, List<ISuite> suites,
                               String outputDirectory) {

        // Tworzymy plik z raportem
        extent = new ExtentReports(outputDirectory + File.separator + "/home/amingielewicz/IdeaProjects/selenium-shop/reports", true);
        //konfiguracje
        extent.addSystemInfo("Host Name", "SoftwareTesting0");
        extent.addSystemInfo("Environment", "Production");
        extent.addSystemInfo("User Name", "STestngo");
        //załadowanie configu
        extent.loadConfig(new File("/home/amingielewicz/IdeaProjects/selenium-shop/extent-config.xml"));
        //zbieranie i przekazywanie rezultatów testów
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                //logowanie testów o takich statusach
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }
        //zatwierdzamy i zamykamy raport
        extent.flush();
        extent.close();
    }

    private void buildTestNodes(IResultMap tests, LogStatus status) { //metoda techniczna, odpowiada za uruchomienie, zebranie i zamknięcie testów.
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());

                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test" + status.toString().toLowerCase() + "ed");
                }

                extent.endTest(test);
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}