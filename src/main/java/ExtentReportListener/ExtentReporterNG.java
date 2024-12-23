package ExtentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.thredup.qa.base.TestBase1;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ExtentReporterNG extends TestBase1 implements ITestListener {
    ExtentReports extent;
    ExtentSparkReporter spark;
    ExtentTest test;

    public ExtentReporterNG() throws IOException {
    }

    @Override
    public void onStart(ITestContext context) {
        extent = new ExtentReports();
        spark= new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReport.html");
        extent.attachReporter(spark);
        spark.config().setDocumentTitle(" ThredUp Automation");
        spark.config().setReportName("ExtentReport Insta");
        spark.config().setTheme(Theme.DARK);

        extent.setSystemInfo("Tester Name ","Ramkumar");
        extent.setSystemInfo("os","Windows11");
        extent.setSystemInfo("browser","Chrome");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        test=extent.createTest(result.getName());
        test.log(Status.PASS,"Test case Passed is : "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test=extent.createTest(result.getName());

        TakesScreenshot ts=(TakesScreenshot)driver;
        String sfil=ts.getScreenshotAs(OutputType.BASE64);

        File sfile=ts.getScreenshotAs(OutputType.FILE);
        File dfile=new File("C:\\Users\\ramku\\IdeaProjects\\ThredUpTest\\src\\main\\java\\com\\crm\\qa\\Screenshot\\"+ result.getMethod().getMethodName() + ".png");
        try {
            FileHandler.copy(sfile, dfile);
        }catch(IOException e){
            e.printStackTrace();
        }
        test.log(Status.FAIL,"Test case Failed is : "+result.getMethod().getMethodName()+" screen shot has been taken").addScreenCaptureFromBase64String(sfil);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test=extent.createTest(result.getName());
        test.log(Status.SKIP,"Test case Skipped is : "+result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
