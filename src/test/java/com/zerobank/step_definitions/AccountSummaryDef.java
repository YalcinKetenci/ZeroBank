package com.zerobank.step_definitions;

import com.zerobank.pages.Dashboard;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class AccountSummaryDef {

    @Then("Account summary page should have the title Zero – Account summary")
    public void account_summary_page_should_have_the_title_Zero_Account_summary() {
        Assert.assertEquals(new Dashboard().dashboardDefaultTitle , Driver.get().getTitle());
    }

    @Then("Account summary page should have to following account types: Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts")
    public void account_summary_page_should_have_to_following_account_types_Cash_Accounts_Investment_Accounts_Credit_Accounts_Loan_Accounts() {
        String[] accountType = {"Cash Accounts","Investment Accounts","Credit Accounts","Loan Accounts"};

    }

    @Then("Credit Accounts table must have columns Account, Credit Card and Balance.")
    public void credit_Accounts_table_must_have_columns_Account_Credit_Card_and_Balance() {
       String[] column = {"Credit Card","Balance"};


    }
}
