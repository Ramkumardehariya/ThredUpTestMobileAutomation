package com.thredup.qa.testcases;


import com.thredup.qa.base.TestBase1;
import com.thredup.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase1 {
    HomePage homePage;
    LoginPageTest loginPageTest;

    public HomePageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        homePage = new HomePage();
    }


    @Test(priority = 3)
    public void homePageTest() throws InterruptedException {
        loginPageTest.loginTest();
        homePage.home();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
