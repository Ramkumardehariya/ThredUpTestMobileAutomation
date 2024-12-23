package com.thredup.qa.testcases;

import com.thredup.qa.base.TestBase1;
import com.thredup.qa.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignUpPageTest extends TestBase1 {
    SignUpPage signUpPage;

    public SignUpPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        signUpPage = new SignUpPage();
    }


    @Test(priority = 3)
    public void signUpTest() throws InterruptedException {
        signUpPage.signUp(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
