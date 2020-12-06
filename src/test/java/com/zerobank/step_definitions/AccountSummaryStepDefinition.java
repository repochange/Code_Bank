package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class AccountSummaryStepDefinition {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    LoginPage loginPage = new LoginPage();

    @Given("User on the Account Summary page")
    public void user_on_the_Account_Summary_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
        loginPage.login();
    }

    @Then("User verifies that the page has next account types")
    public void user_verifies_that_the_page_has_next_account_types(List<String> dataTable) {
       accountSummaryPage.verifyAccountTypesAreDisplayed(dataTable);
    }

    @Then("User verifies that Credit account table has next columns")
    public void user_verifies_that_Credit_account_table_has_next_columns(List<String> dataTable) {
        accountSummaryPage.columnsAreDisplayed(dataTable);
    }

}
