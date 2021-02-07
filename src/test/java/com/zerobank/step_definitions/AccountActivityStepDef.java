package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.Dashboard;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDef {

    @When("the user click {string} module")
    public void the_user_click_module(String string) {
       new Dashboard().goToModule(string);
    }

    @Then("In the Account drop down default option should be {string}")
    public void in_the_Account_drop_down_default_option_should_be(String string) {

        Select select = new Select(new AccountActivity().selectDropDown);
        Assert.assertEquals(string,select.getFirstSelectedOption().getText());
    }

    @Then("Account drop down should have the following options: Savings, Checking, Loan, Credit Card, Brokerage")
    public void account_drop_down_should_have_the_following_options_Savings_Checking_Loan_Credit_Card_Brokerage(List<String> dataTable) {
        Select select = new Select(new AccountActivity().selectDropDown);
        Assert.assertEquals(dataTable, BrowserUtils.getElementsText(select.getOptions()));
    }

    @Then("Transactions table should have column names Date, Description, Deposit, Withdrawal")
    public void transactions_table_should_have_column_names_Date_Description_Deposit_Withdrawal(List<String> dataTable) {
        Assert.assertEquals(dataTable,BrowserUtils.getElementsText(new AccountActivity().transactionHeaders));
    }


}
