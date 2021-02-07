package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ISelect;

import java.util.List;

public class AccountActivity extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement selectDropDown;

    @FindBy(tagName = "th")
    public List<WebElement> transactionHeaders;

}
