package com.zerobank.step_definitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class payBillStepDef {

    @When("the user select the {string} as a payee")
    public void the_user_select_the_as_a_payee(String string) {
        for (WebElement webElement : new PayBills().payee) {
            if (webElement.getText().equals(string)) {
                webElement.click();
            }
        }
    }

    @When("the user select the {string} as a account")
    public void the_user_select_the_as_a_account(String string) {
        for (WebElement account : new PayBills().accounts) {
            if (account.getText().equals(string)) {
                account.click();
            }
        }
    }

    @When("the user enter {string} as a amount")
    public void the_user_enter_as_a_amount(String string) {
        new PayBills().amountTextBox.sendKeys(string);
    }

    @When("the user click the date text box")
    public void the_user_click_the_date_text_box() {
        new PayBills().dateBox.click();
    }

    @When("the user choose {string} as a date")
    public void the_user_choose_as_a_date(String string) {
        new PayBills().chooseTheDate(string);
    }

    @When("the user enter {string} as a description")
    public void the_user_enter_as_a_description(String string) {
        new PayBills().descriptionTextBox.sendKeys(string);
    }

    @When("the user click pay button")
    public void the_user_click_pay_button() {
        new PayBills().payButton.click();
    }

    @Then("The payment was successfully submitted should be displayed")
    public void the_payment_was_successfully_submitted_should_be_displayed() {
        Assert.assertTrue(new PayBills().submittedAlert.isDisplayed());
    }


    @Then("Please fill out this field message! should be displayed")
    public void please_fill_out_this_field_message_should_be_displayed() {

        //Alert alert =  Driver.get().switchTo().alert();
        //String actualResult = alert.getText();
        String actualResult = new PayBills().amountTextBox.getAttribute("validationMessage");
        String expectedResult = "Please fill in this field.";
        Assert.assertEquals(expectedResult,actualResult);

    }
}
