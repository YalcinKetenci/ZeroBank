package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement selectDropDown;

    @FindBy(tagName = "th")
    public List<WebElement> transactionHeaders;

    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    @FindBy(id = "aa_fromDate")
    public WebElement datesBox_From;

    @FindBy(id = "aa_toDate")
    public WebElement datesBox_To;

    @FindBy(id = "aa_fromAmount")
    public WebElement amountBox_From;

    @FindBy(id = "aa_toAmount")
    public WebElement amountBox_To;

    @FindBy(id = "aa_type")
    public WebElement types;

    @FindBy( xpath = "//button[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//thead//th")
    public List<WebElement> headersOfResultTable;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[1]")
    public List<WebElement> datesInTheResult;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[2]")
    public List<WebElement> descriptionsInTheResult;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[3]")
    public List<WebElement> depositsInTheResult;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[4]")
    public List<WebElement> withdrawalsInTheResult;

    public List<String> getTypeNames(){
        Select select = new Select(types);
        return BrowserUtils.getElementsText(select.getOptions());
    }

    public void goToModuleOfAccountActivity(String moduleName){
        Driver.get().findElement(By.xpath("//*[.='"+moduleName+"']/a")).click();
    }

    public void clickTheType(String typeName){
        Select select = new Select(types);

        select.selectByValue(typeName.toUpperCase());

        findButton.click();

        BrowserUtils.waitFor(2);
    }

    public boolean rangeOfTheDateInTheResult(String from, String to) {
        String[] from_ = from.split("-");
        String[] to_ = to.split("-");

        String fromDate = "";
        String toDate = "";

        for (String s : from_) {
            fromDate+=s;
        }
        for (String s : to_) {
            toDate+=s;
        }

        int fromDateInt = Integer.parseInt(fromDate);
        int toDateInt = Integer.parseInt(toDate);

        List<Integer> resultDatesInt = new ArrayList<>();
        while (true){
            try {

                for (WebElement webElement : datesInTheResult) {
                    String str = "";
                    for (int i = 0; i < webElement.getText().length(); i++) {
                        if (Character.isDigit(webElement.getText().charAt(i))) {
                            str += webElement.getText().charAt(i);
                        }
                    }
                    resultDatesInt.add(Integer.parseInt(str));
                }
                break;
            }catch (StaleElementReferenceException e){

            }
        }

        for (Integer integer : resultDatesInt) {
            if (integer>toDateInt || integer<fromDateInt){
                return false;
            }else {
                return true;
            }
        }






        return false;
    }

    public List<Integer> getDatesInTheResultAsInteger(){
        ArrayList<String> dates = new ArrayList<>();
        for (WebElement webElement : datesInTheResult) {
            dates.add(webElement.getText().replace("-",""));
        }
        ArrayList<Integer> datesInt = new ArrayList<>();
        for (String date : dates) {
            datesInt.add(Integer.parseInt(date));
        }
        return datesInt;
    }


    public List<String> getAllDescriptionsFromTheResultsAsString(){

        List<String> strList = new ArrayList<>();
        for (WebElement webElement : descriptionsInTheResult) {
            strList.add(webElement.getText());
        }
        return strList;
    }

    public List<String> getAllDepositsFromTheResultAsString(){
        List<String> strList = new ArrayList<>();
        for (WebElement webElement : depositsInTheResult) {
            strList.add(webElement.getText());
        }
        return strList;
    }

    public List<String> getAllWithdrawalsFromTheResultAsString(){
        List<String> strList = new ArrayList<>();
        for (WebElement webElement : withdrawalsInTheResult) {
            strList.add(webElement.getText());
        }
        return strList;
    }

    public void cleanAllBox(){
        descriptionBox.clear();
        datesBox_From.clear();
        datesBox_To.clear();
    }

}
