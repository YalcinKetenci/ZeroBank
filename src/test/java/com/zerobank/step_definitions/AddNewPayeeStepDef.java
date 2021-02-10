package com.zerobank.step_definitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class AddNewPayeeStepDef {

    @Given("{string} tab")
    public void tab(String string) {
        new PayBills().goToModulesOfPayBills(string);
    }

    @Given("create new payee using following information")
    public void create_new_payee_using_following_information(Map<String,String> dataTable) {
        for (String s : new PayBills().getAddNewPayeeInformationNamesAsString()) {
            try {
                Driver.get().findElement(By.xpath("//*[.='" + s + "']/../div/input")).sendKeys(dataTable.get(s));
            }catch (Exception e){
                Driver.get().findElement(By.xpath("//*[.='" + s + "']/../div/textarea")).sendKeys(dataTable.get(s));
            }
        }
        new PayBills().addNewPayeeBtn.click();

    }

    @Then("message The new payee The Law Offices of Hyde, Price @ Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        Assert.assertTrue(new PayBills().submittedAlert.isDisplayed());
    }
}
