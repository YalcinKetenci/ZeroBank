package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.Dashboard;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class AccountSummaryStepDef {

    @Then("page should have the title {string}")
    public void page_should_have_the_title(String string) {
        Assert.assertEquals(string , Driver.get().getTitle());
    }

    @Then("Account summary page should have to following account types: Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts")
    public void account_summary_page_should_have_to_following_account_types_Cash_Accounts_Investment_Accounts_Credit_Accounts_Loan_Accounts(List<String> dataTable) {
            Assert.assertEquals(dataTable,new AccountSummary().getAccountNames());
    }

    @Then("Credit Accounts table must have columns Account, Credit Card and Balance.")
    public void credit_Accounts_table_must_have_columns_Account_Credit_Card_and_Balance(List<String> dataTable) {
            Assert.assertEquals(dataTable,new AccountSummary().getCreditAccountHeaders());
    }
}
