package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dashboard extends BasePage{


    @FindBy(id= "account_summary_tab")
    public WebElement accountSummaryModule;


    public String dashboardDefaultTitle = "Zero - Account Summary";

    public void goToModule(String moduleName){
        Driver.get().findElement(By.xpath("//a[.='"+moduleName+"']")).click();

    }

}
