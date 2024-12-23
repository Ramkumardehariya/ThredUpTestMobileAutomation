package com.thredup.qa.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class TestBase1 {
    public static Properties prop;
    public static AndroidDriver driver;
    public static Logger log = Logger.getLogger(String.valueOf(TestBase1.class));

    public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");


    public TestBase1() throws IOException {
        prop=new Properties();
        FileInputStream ip = new   FileInputStream("C:\\Users\\ramku\\IdeaProjects\\ThredUpTestMobileAutomation\\src\\main\\java\\com\\thredup\\qa\\config\\config.properties");
        prop.load(ip);
    }

    public static void initialization() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options()
                .setAppActivity("com.thredup.android.feature.splash.SplashActivity")
                .setAppPackage("com.thredup.android")
                .setDeviceName("emulator-5556")
                .setPlatformName("Android")
                .setPlatformVersion("9.0")
                .setNewCommandTimeout(Duration.ofSeconds(300)); // Updated syntax for timeout

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);

        System.out.println("Start Automation .......");

        log.info("Start automation .....");
    }
}