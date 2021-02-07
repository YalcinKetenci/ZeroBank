package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBills extends BasePage {

    @FindBy(id = "sp_payee")
    public List<WebElement> payee;

    @FindBy(id = "sp_account")
    public List<WebElement> accounts;

    @FindBy(id = "sp_amount")
    public WebElement amountTextBox;

    @FindBy(id = "sp_description")
    public WebElement descriptionTextBox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(id = "alert_content")
    public WebElement submittedAlert;

    @FindBy(id = "sp_date")
    public WebElement dateBox;

    public void chooseTheDate(String day){
        Driver.get().findElement(By.xpath("//td[.='"+day+"']")).click();

    }


}
