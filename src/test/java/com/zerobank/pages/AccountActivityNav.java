package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class AccountActivityNav extends AccountActivity{

    @FindBy(xpath = "(//tr[1]/td[1])[2]")
    public WebElement brokerage;

    @FindBy(xpath = "(//tr[1]/td[1])[1]")
    public WebElement savings;

    @FindBy(xpath = "//tr/td[1]")
    public List<WebElement> allAccounts;

    public Set<String> allAccountNamesAsSet(){
        Set<String> accountNames= null;
        for (WebElement allAccount : allAccounts) {
            accountNames.add(allAccount.getText());
        }
        return accountNames;
    }

    public void clickTheAccount(String accountName){
        Driver.get().findElement(By.xpath("//td/a[.='"+accountName+"']")).click();
    }

}
