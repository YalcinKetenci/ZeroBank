package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
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

    @FindBy(xpath = "(//fieldset)[2]/div[@class='control-group']/label")
    public List<WebElement> getAddNewPayeeInformationNames;

    @FindBy(id = "add_new_payee")
    public WebElement addNewPayeeBtn;

    @FindBy(id = "pc_currency")
    public WebElement currencies;

    @FindBy(id = "pc_amount")
    public WebElement currencyAmountTextBox;

    @FindBy(xpath = "//*[@id='ui-tabs-3']/h2")
    public WebElement currencyHeader;

    @FindBy( id = "pc_inDollars_false")
    public WebElement selectedCurrencyRadioBtn;

    @FindBy(id = "purchase_cash")
    public WebElement purchaseButton;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsBtn;




    public void chooseTheDate(String day){
        Driver.get().findElement(By.xpath("//td[.='"+day+"']")).click();

    }

    public void goToModulesOfPayBills(String moduleName){
       Driver.get().findElement(By.xpath("//*[.='"+moduleName+"']")).click();

    }

    public List<String> getAddNewPayeeInformationNamesAsString(){
        return BrowserUtils.getElementsText(getAddNewPayeeInformationNames);
    }

    public List<String> getAllCurrenciesAsStingWithoutDefault(){
        List<String> str = new ArrayList<>();
        Select select = new Select(currencies);
        str = BrowserUtils.getElementsText(select.getOptions());
        str.remove(select.getFirstSelectedOption().getText());
        return str;
    }

    public List<String> getAllCurrenciesAsSting(){
        List<String> str = new ArrayList<>();
        Select select = new Select(currencies);
        str = BrowserUtils.getElementsText(select.getOptions());
        return str;
    }

    public List<WebElement> getAllCurrenciesWithoutDefault(){
        Select select = new Select(currencies);
        List<WebElement> str = new ArrayList<>();
        str = select.getOptions();
        str.remove(select.getFirstSelectedOption());
        return str;
    }

    public List<WebElement> getAllCurrencies(){
        Select select = new Select(currencies);
        List<WebElement> str = new ArrayList<>();
        str = select.getOptions();
        return str;
    }


}
