package com.thredup.qa.testcases;
import com.thredup.qa.base.TestBase1;
import com.thredup.qa.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends TestBase1 {
    LogInPage logInPage;

    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        logInPage = new LogInPage();
    }

    @Test(priority = 3)
    public void loginTest() throws InterruptedException {
        logInPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
