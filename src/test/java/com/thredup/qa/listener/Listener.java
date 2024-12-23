package com.thredup.qa.listener;

import com.aventstack.extentreports.ExtentTest;

import com.thredup.qa.util.TestUtil;
import com.thredup.qa.base.TestBase1;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class Listener extends TestBase1 implements ITestListener {

    TestUtil utility;

    public Listener() throws IOException {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+": onTestSuccess");
        System.out.println(result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+":onTestFailure");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Ramkumar");
        test.fail("Test method failed");
        String fTname = result.getMethod().getMethodName();
        try {
            utility = new TestUtil();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            utility.failedTest(fTname);
        }catch (IOException e){
            e.printStackTrace();
        }

        test.addScreenCaptureFromPath("C:\\Users\\ramku\\IdeaProjects\\ThredUpTest\\src\\main\\java\\com\\crm\\qa\\Screenshot\\"+result.getMethod().getMethodName()+".png");
        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+":onTestSkipped");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.skip("Test method skipped");
        extent.flush();
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting Test Suite: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finishing Test Suite: " + context.getName());
    }
}
