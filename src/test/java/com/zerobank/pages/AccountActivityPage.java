package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AccountActivityPage extends BasePage {

    @FindBy(xpath = "//*[@value]")
    public List <WebElement> accountDropdownValues;

    @FindBy(xpath = "//table[@class= 'table table-condensed table-hover']//th")
    public List<WebElement> transactionsTableColumns;

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(css = "input[name = 'fromDate']")
    public WebElement fromDateBox;

    @FindBy(css = "input[name = 'toDate']")
    public WebElement toDateBox;

    @FindBy(css = "button[type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]/tbody//tr//td[1]") // All presented dates of selected range of dates
    public List<WebElement> listOfSelectedDates;

    @FindBy(name = "description")
    public WebElement descriptionBox;

    @FindBy(xpath = "(//table[@class = 'table table-condensed table-hover'])[2]//tbody/tr/td[2]") // ONLINE or OFFICE
    public List<WebElement> presentedDescriptionList;

    @FindBy(xpath = "(//table[@class = 'table table-condensed table-hover'])[2]//tbody/tr/td[3]") // Some values
    public List<WebElement> presentedDepositList;

    @FindBy(xpath = "(//table[@class = 'table table-condensed table-hover'])[2]//tbody/tr/td[4]") // Some values
    public List<WebElement> presentedWithdrawalList;

    @FindBy(xpath = "//*[text()[contains(., 'No result')]]")
    public WebElement noResultMessage;

    @FindBy(css = "select[id ='aa_type']")
    public WebElement typeDropdown;


    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public void accountDropdownContainsOptions(List<String> expectedValues){
        for (int i =0; i<accountDropdownValues.size(); i++){
            Assert.assertTrue(expectedValues.contains(accountDropdownValues.get(i).getText()));
        }
        Assert.assertTrue(accountDropdownValues.size()==expectedValues.size());
        System.out.println("Dropdown values are matches");
    }

    public void verifyTransactionsTableHasColumns(List<String> expectedValues){
        for (int i = 0; i <transactionsTableColumns.size() ; i++) {
           Assert.assertEquals("Wrong columns name", transactionsTableColumns.get(i).getText(), expectedValues.get(i));
           Assert.assertTrue(transactionsTableColumns.get(i).isDisplayed());
        }
        System.out.println("All the Transactions column names are displayed and match");

    }
    public void verifyDefaultValueDropdown(String expected){
        Select select = new Select(accountDropdown);
        String defaultValue = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Wrong default value", expected, defaultValue);

    }

    public void clickLink(String linkName) {
        Driver.get().findElement(By.linkText(linkName)).click();  ///    \
        BrowserUtils.wait(1);
    }

    public void checkTheDates(String startDate, String endDate, String givenDate) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = simpleDateFormat.parse(startDate);
            Date date2 = simpleDateFormat.parse(endDate);
            Date date3 = simpleDateFormat.parse(givenDate);
            Assert.assertTrue("Date is out of the range", date3.compareTo(date1)>=0 && date3.compareTo(date2)<=0 );

            //compareTo()----->

//            It returns the value 0 if the argument Date is equal to this Date.
//            It returns a value less than 0 if this Date is before the Date argument.
//            It returns a value greater than 0 if this Date is after the Date argument.
        }catch (ParseException pe){
            pe.printStackTrace();
        }
    }

    //sort the list of the dates from the account activity page and compare it with other list of the dates

    public void verifyIfSorted(List<WebElement> actual){
        List<String> expected = new ArrayList<>();
        actual.forEach(each->{
            expected.add(each.getText());
        });
        Collections.sort(expected, Collections.reverseOrder());  // sorted by descending order
        if(expected.size()==actual.size()){
            for(int i = 0; i<expected.size();i++) {
                Assert.assertTrue(expected.get(i).equals(actual.get(i).getText()));
            }
        }
    }


}
