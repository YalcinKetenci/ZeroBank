package com.zerobank.step_definitions;

import com.zerobank.pages.Dashboard;
import com.zerobank.pages.Login;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enter valid username and password")
    public void the_user_enter_valid_username_and_password() throws InterruptedException {
        new Login().login();
    }

    @Then("Account Summary page should be displayed")
    public void account_Summary_page_should_be_displayed() {
        Assert.assertEquals(new Dashboard().dashboardDefaultTitle, Driver.get().getTitle());
    }

    @When("the user enter invalid username and password")
    public void the_user_enter_invalid_username_and_password() throws InterruptedException {
        new Login().invalidLogin();
    }

    @Then("Account Summary page should NOT be displayed")
    public void account_Summary_page_should_NOT_be_displayed() {
        Assert.assertNotEquals(new Dashboard().dashboardDefaultTitle, Driver.get().getTitle());
    }



}
