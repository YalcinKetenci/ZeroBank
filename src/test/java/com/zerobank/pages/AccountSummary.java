package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountSummary extends BasePage{


    @FindBy(tagName = "h2")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//table)[3]//th")
    public List<WebElement> creditAccountHeader;

    public List<String> getAccountNames(){
        List<WebElement> elements = accountTypes;
        return BrowserUtils.getElementsText(elements);
    }

    public List<String> getCreditAccountHeaders(){
        List<WebElement> elements = creditAccountHeader;
        return BrowserUtils.getElementsText(elements);
    }


}
