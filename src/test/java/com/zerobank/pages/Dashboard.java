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
        String module ="";
        String[] str = moduleName.split(" ");

        if (str.length>0){
            for (int i = 0; i < str.length; i++) {
                module += ""+str[i].charAt(0);
                module+= module.toUpperCase();
                module+=str[i].substring(1).toLowerCase();
            }
        }else{
            module += moduleName.charAt(0);
            module+= module.toUpperCase();
            module+=moduleName.substring(1).toLowerCase();
        }

        module.trim();

        Driver.get().findElement(By.xpath("//a[.='"+module+"']")).click();
    }

}
