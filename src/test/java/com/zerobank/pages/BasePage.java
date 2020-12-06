package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

public class BasePage {


    public void verifySubtitle(String expected) {
        Assert.assertEquals("Wrong Subtitle", expected, Driver.get().getTitle());
    }

    public void navigateTo(String tabName) {
        BrowserUtils.wait(1);
        if (!Driver.get().getTitle().contains("Zero - Log in") || !Driver.get().getTitle().contains("Zero - Personal Banking - Loans - Credit Cards")) {
            if (!Driver.get().getTitle().contains(tabName)) {
                Driver.get().findElement(By.xpath("//a[text()[contains(.,'" + tabName + "')]]")).click();
            }
        }
    }

    public void verifyMessage(String expectedMessage, WebElement message){
        Assert.assertTrue(message.getText().equals(expectedMessage) && message.isDisplayed());
    }

    public void selectDropdownOptionByVisibleText(WebElement dropdown, String visibleText){
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }


    public void verifyDefaultValueDropdown(String expected, WebElement dropdown) {
        Select select = new Select(dropdown);
        String defaultValue = select.getFirstSelectedOption().getText().trim();
        Assert.assertEquals("Wrong default value", expected, defaultValue);
    }
    public void selectDropdown(WebElement dropdown, String byValue ){
        Select select = new Select(dropdown);
        select.selectByValue(byValue.charAt(byValue.length()-1)+"");
    }

}
