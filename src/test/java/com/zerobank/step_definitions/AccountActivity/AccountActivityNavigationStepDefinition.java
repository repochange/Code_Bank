package com.zerobank.step_definitions.AccountActivity;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountActivityNavigationStepDefinition {

    WebDriverWait wait;
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("User clicks on {string} link on the Account Summary page")
    public void user_clicks_on_link_on_the_Account_Summary_page(String link) {
        Driver.get().findElement(By.xpath("//a[text()[contains(., '" + link + "')]]")).click();
        BrowserUtils.wait(2);

    }

    @Then(value = "The {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedSubtitle) {
//        wait = new WebDriverWait(Driver.get(),20);
//        wait.until(ExpectedConditions.titleContains(expectedSubtitle));
        System.out.println(Driver.get().getTitle());
        Assert.assertTrue("You are not on the Account Activity page! Wrong Subtitle",
                Driver.get().getTitle().contains(expectedSubtitle));
    }


    @Then("Account	dropdown should	have {string} selected")
    public void account_dropdown_should_have_selected(String expectedSelectedDropdownValue) {
        Select select = new Select(accountActivityPage.accountDropdown);
        Assert.assertEquals("Selected dropdown value is different!", expectedSelectedDropdownValue, select.getFirstSelectedOption().getText());

    }


}
