package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.cs.Ale;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage{

    String securityTitle = "";

    @FindBy(id = "user_login")
    public WebElement usernameBox;

    @FindBy(id = "user_password")
    public WebElement passwordBox;

    @FindBy(name = "submit")
    public WebElement singIn;






    public void securityAlert(){
        if (Driver.get().getTitle()!= new Dashboard().dashboardDefaultTitle ) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.get();
            js.executeScript("arguments[0].click()", Driver.get().findElement(By.id("details-button")));
            js.executeScript("arguments[0].click()", Driver.get().findElement(By.id("proceed-link")));
        }
    }

    public void login() throws InterruptedException {
        signInBtn.click();
        usernameBox.sendKeys(ConfigurationReader.get("username"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        singIn.click();
        securityAlert();
    }



    public void invalidLogin(){
        signInBtn.click();
        usernameBox.sendKeys("askldasdlk");
        passwordBox.sendKeys("adsadasdsd");
        singIn.click();
    }
}
