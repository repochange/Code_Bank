package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(tagName = "h2")
    List<WebElement> accountTypes; //

    @FindBy(xpath = "(//table[@class = 'table'])[3]//tr/th")
    List <WebElement> creditAccountTableColumns; // Account, Credit card, Balance

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public void verifyAccountTypesAreDisplayed(List<String> expected){
        for(int i =0; i<accountTypes.size(); i++){
            boolean a =accountTypes.get(i).getText().equals(expected.get(i)) && accountTypes.get(i).isDisplayed();
            Assert.assertTrue(a);
        }
        System.out.println("All the Account Types are displayed \n"+ "############################");
    }

    public void columnsAreDisplayed(List<String> expected){
        for (int i = 0; i < creditAccountTableColumns.size() ; i++) {
            boolean a = creditAccountTableColumns.get(i).getText().equals(expected.get(i)) && creditAccountTableColumns.get(i).isDisplayed();
            Assert.assertTrue(a);
        }
        System.out.println("All the columns are displayed \n"+ "############################");
    }


}
