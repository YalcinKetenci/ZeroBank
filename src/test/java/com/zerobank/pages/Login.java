package com.zerobank.pages;

import com.zerobank.step_definitions.AccountActivityStepDef;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.an.E;
import io.cucumber.java.cs.Ale;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BasePage {

    String securityTitle = "";

    @FindBy(id = "user_login")
    public WebElement usernameBox;

    @FindBy(id = "user_password")
    public WebElement passwordBox;

    @FindBy(name = "submit")
    public WebElement singIn;


    public void securityAlert() {
        switch (ConfigurationReader.get("browser")) {
            case "chrome":
                try {
                        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
                        js.executeScript("arguments[0].click()", Driver.get().findElement(By.id("details-button")));
                        js.executeScript("arguments[0].click()", Driver.get().findElement(By.id("proceed-link")));

                } catch (Exception e) {}
                break;
            case "firefox":
                try {
                        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
                        new WebDriverWait(Driver.get(),5000).until(ExpectedConditions.elementToBeClickable(Driver.get().findElement(By.id("enableTls10Button"))));
                        js.executeScript("arguments[0].click()", Driver.get().findElement(By.id("enableTls10Button")));
                        new WebDriverWait(Driver.get(),5000).until(ExpectedConditions.elementToBeClickable(Driver.get().findElement(By.id("advancedButton"))));
                        js.executeScript("arguments[0].click()", Driver.get().findElement(By.id("advancedButton")));
                        new WebDriverWait(Driver.get(),5000).until(ExpectedConditions.elementToBeClickable(Driver.get().findElement(By.id("exceptionDialogButton"))));
                        js.executeScript("arguments[0].click()", Driver.get().findElement(By.id("exceptionDialogButton")));
                    }catch (Exception e){}
                break;
            case "safari":
                try{
                    JavascriptExecutor js = (JavascriptExecutor) Driver.get();
                    js.executeScript("CertificateWarningController.visitInsecureWebsiteWithTemporaryBypass()");
                }catch (Exception e ){}
                break;
        }

    }

    public void login() throws InterruptedException {
        signInBtn.click();
        Thread.sleep(2000);
        usernameBox.sendKeys(ConfigurationReader.get("username"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        singIn.click();
        securityAlert();
        }
        public void invalidLogin () {
            signInBtn.click();
            usernameBox.sendKeys("askldasdlk");
            passwordBox.sendKeys("adsadasdsd");
            singIn.click();
        }


}
