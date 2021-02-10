package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.PayBills;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FindTransactionsStepDef {
    public int _userFromDate;
    public int _userToDate;

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String string) {
        new PayBills().goToModulesOfPayBills(string);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        new AccountActivity().datesBox_From.sendKeys(string);
        new AccountActivity().datesBox_To.sendKeys(string2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to)  {
        Assert.assertTrue(new AccountActivity().rangeOfTheDateInTheResult(from,to));
        _userFromDate = Integer.parseInt(from.replace("-",""));
        _userToDate = Integer.parseInt(to.replace("-",""));
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        for (int i = 0; i < new AccountActivity().getDatesInTheResultAsInteger().size(); i++) {
           try {
               if (new AccountActivity().getDatesInTheResultAsInteger().get(i) > new AccountActivity().getDatesInTheResultAsInteger().get(i + 1)) {
                   Assert.assertTrue(true);
               } else {
                   Assert.assertTrue(false);
               }
           }catch (Exception e){}

        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        int dateInteger = Integer.parseInt(string.replace("-",""));
            Assert.assertTrue(dateInteger> _userToDate || dateInteger< _userFromDate);


    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        new AccountActivity().descriptionBox.sendKeys(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        while (true) {
            try {
                for (String s : new AccountActivity().getAllDescriptionsFromTheResultsAsString()) {
                    Assert.assertTrue(s.contains(string));
                }
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }

    @Given("clicks search")
    public void clicks_search() throws InterruptedException {
        new AccountActivity().findButton.click();
        new AccountActivity().cleanAllBox();
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) throws InterruptedException {
        new AccountActivity().clickTheType(string);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() throws InterruptedException {
        Thread.sleep(1000);
        List<String> strList = new ArrayList<>();
        for (WebElement webElement : Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//td[3]"))) {
            strList.add(webElement.getText());
        }
        String str ="";
        for (String s : strList) {
            str+=s;
        }
        Assert.assertFalse(str.isBlank());

    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() throws InterruptedException {
        List<String> strList = new ArrayList<>();
        for (WebElement webElement : Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//td[4]"))) {
            strList.add(webElement.getText());
        }
        String str ="";
        for (String s : strList) {
            str+=s;
        }
        System.out.println(str);
        Assert.assertFalse(str.isBlank());
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        List<String> strList = new ArrayList<>();
        for (WebElement webElement : Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//td[4]"))) {
            strList.add(webElement.getText());
        }
        String str ="";
        for (String s : strList) {
            str+=s;
        }
        Assert.assertTrue(str.isBlank());
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        List<String> strList = new ArrayList<>();
        for (WebElement webElement : Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//td[3]"))) {
            strList.add(webElement.getText());
        }
        String str ="";
        for (String s : strList) {
            str+=s;
        }

        Assert.assertTrue(str.isBlank());
    }
}
