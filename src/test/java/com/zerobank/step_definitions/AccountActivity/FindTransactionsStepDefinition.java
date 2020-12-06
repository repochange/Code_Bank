package com.zerobank.step_definitions.AccountActivity;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FindTransactionsStepDefinition {

    AccountActivityPage accountActivityPage = new AccountActivityPage();
    WebDriverWait wait;


    @Given("User clicks on the {string} tab")
    public void user_clicks_on_the_tab(String linkName) {
        accountActivityPage.clickLink(linkName);
        BrowserUtils.wait(1);
    }

    @When("User enters date range from {string} to {string}")
    public void user_enters_date_range_from_to(String startDate, String endDate) {
    accountActivityPage.fromDateBox.sendKeys(startDate);
    accountActivityPage.toDateBox.sendKeys(endDate);


    }

    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.findButton.click();
        BrowserUtils.wait(1);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String startDate, String endDate) {
        for(int i =0; i<accountActivityPage.listOfSelectedDates.size();i++){
            accountActivityPage.checkTheDates(startDate, endDate, accountActivityPage.listOfSelectedDates.get(i).getText());
        }
    }

    @When("User refresh the page")
    public void user_refresh_the_page() {
        Driver.get().navigate().refresh();
        BrowserUtils.wait(1);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        accountActivityPage.verifyIfSorted(accountActivityPage.listOfSelectedDates);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String givenDate) {
        List<String> textValue = new ArrayList<>();
        for (int i=0; i<accountActivityPage.listOfSelectedDates.size();i++){
            textValue.add(accountActivityPage.listOfSelectedDates.get(i).getText());
        }
        Assert.assertFalse("Result table contains given date", textValue.contains(givenDate));
    }

    @When("User enters description {string}")
    public void user_enters_description(String description) {
        accountActivityPage.descriptionBox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        for (int i =0; i<accountActivityPage.presentedDescriptionList.size(); i++){
            Assert.assertTrue("Result is not "+description,accountActivityPage.presentedDescriptionList.get(i).getText().substring(0,6).equals(description));

        }
    }

    @When("User deletes previous input")
    public void user_deletes_previous_input() {
        accountActivityPage.descriptionBox.sendKeys(Keys.CONTROL, "a");
        accountActivityPage.descriptionBox.sendKeys(Keys.DELETE);

    }
    @Then("results table should display {string}")
    public void results_table_should_display(String description) {
        Assert.assertEquals("Wrong message",accountActivityPage.noResultMessage.getText(), description);
    }


    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        for (int i = 0; i <accountActivityPage.presentedDepositList.size() ; i++) {
            if(accountActivityPage.presentedDepositList.get(i).getText().length()>0){
                Assert.assertTrue("No values under Deposit tub",accountActivityPage.presentedDepositList.get(i).getText().length()>0);
                System.out.println("At least one value under Deposit is "+accountActivityPage.presentedDepositList.get(i).getText());
                break;
            }
        }

    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        for (int i = 0; i <accountActivityPage.presentedWithdrawalList.size() ; i++) {
            if(accountActivityPage.presentedWithdrawalList.get(i).getText().length()>0){
                Assert.assertTrue("No values under Deposit tub",accountActivityPage.presentedWithdrawalList.get(i).getText().length()>0);
                System.out.println("At least one value under Withdrawal is "+accountActivityPage.presentedWithdrawalList.get(i).getText());
                break;
            }
        }

    }

    @When("user selects type {string}")
    public void user_selects_type(String dropdownValue) {
        Select select = new Select(accountActivityPage.typeDropdown);
        select.selectByVisibleText(dropdownValue);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        for (int i = 0; i <accountActivityPage.presentedWithdrawalList.size() ; i++) {
                Assert.assertTrue("Some values under Withdrawal tub",accountActivityPage.presentedWithdrawalList.get(i).getText().length()==0);
                System.out.println("Length of the value under Withdrawal is "+accountActivityPage.presentedWithdrawalList.get(i).getText().length());
        }
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        for (int i = 0; i <accountActivityPage.presentedDepositList.size() ; i++) {
            Assert.assertTrue("Some values under Deposit tub",accountActivityPage.presentedDepositList.get(i).getText().length()==0);
            System.out.println("Length of the value under Deposit is "+accountActivityPage.presentedDepositList.get(i).getText().length());
        }
    }







}
