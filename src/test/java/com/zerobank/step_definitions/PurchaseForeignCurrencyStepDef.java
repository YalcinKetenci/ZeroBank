package com.zerobank.step_definitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDef {
    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        Select select = new Select(new PayBills().currencies);
        for (String s : dataTable) {
            for (WebElement webElement : new PayBills().getAllCurrenciesWithoutDefault()) {
                if(webElement.getText().equals(s)){

                    select.selectByValue(webElement.getAttribute("value"));
                    Assert.assertTrue(webElement.isSelected());
                }
            }
        }

    }


    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        new PayBills().currencyAmountTextBox.sendKeys("100");
        new PayBills().selectedCurrencyRadioBtn.click();
        new PayBills().calculateCostsBtn.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertEquals("Please, ensure that you have filled all the required fields with valid values.", alert.getText());

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Select select = new Select(new PayBills().currencies);
        select.selectByIndex(2);
        new PayBills().selectedCurrencyRadioBtn.click();
        new PayBills().calculateCostsBtn.click();

    }
}
