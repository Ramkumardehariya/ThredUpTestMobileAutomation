package com.thredup.qa.pages;

import com.thredup.qa.base.TestBase1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class HomePage extends TestBase1 {

//    @FindBy(id="com.thredup.android:id/email")
//    WebElement clickOntermAndCondition;

    @FindBy(id="com.thredup.android:id/sell")
    WebElement clickSellPage;

    @FindBy(id = "com.thredup.android:id/saveitem")
    WebElement clickOnSaveItem;

    @FindBy(id = "com.thredup.android:id/addtocart")
    WebElement clickOnAddtoCart;

    @FindBy(id = "com.thredup.android:id/gift")
    WebElement clickOnGiftCart;


    public HomePage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void home() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(clickOnSaveItem));
        clickOnSaveItem.click();

        wait.until(ExpectedConditions.visibilityOf(clickOnAddtoCart));
        clickOnAddtoCart.click();

        wait.until(ExpectedConditions.visibilityOf(clickOnGiftCart));
        clickOnGiftCart.click();
    }
}
