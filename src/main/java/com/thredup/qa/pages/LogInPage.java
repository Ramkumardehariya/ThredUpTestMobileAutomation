package com.thredup.qa.pages;

import com.thredup.qa.base.TestBase1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LogInPage extends TestBase1 {

    @FindBy(id="com.thredup.android:id/email")
    WebElement username;

    @FindBy(id = "com.thredup.android:id/continue_button")
    WebElement clickForLogin;

    @FindBy(id="com.thredup.android:id/password")
    WebElement password;

    @FindBy(id = "com.thredup.android:id/continue_button")
    WebElement loginBtn;

    public LogInPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void login(String un, String pwd) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(un);

        wait.until(ExpectedConditions.elementToBeClickable(clickForLogin));
        clickForLogin.click();

        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pwd);

        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
    }

}
