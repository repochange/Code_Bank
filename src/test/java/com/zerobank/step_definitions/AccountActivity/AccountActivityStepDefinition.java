package com.zerobank.step_definitions.AccountActivity;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinition {

    LoginPage loginPage = new LoginPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("User on the Home page")
    public void user_on_the_Home_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
        loginPage.login();
    }

    @Given("User on the {string} page")
    public void user_on_the_page(String pageName) {
        accountActivityPage.navigateTo(pageName);
    }

    @Then("User verifies that Account dropdown default option is{string}")
    public void user_verifies_that_Account_dropdown_default_option_is(String expectedDefaultDropdownValue) {
        accountActivityPage.verifyDefaultValueDropdown(expectedDefaultDropdownValue);
    }

    @Then("User verifies that Account dropdown has following options")
    public void user_verifies_that_Account_dropdown_has_following_options(List<String> dataTable) {
        accountActivityPage.accountDropdownContainsOptions(dataTable);
    }

    @Then("User verifies that Show Transactions table has next columns")
    public void user_verifies_that_Show_Transactions_table_has_next_columns(List<String> dataTable) {
        accountActivityPage.verifyTransactionsTableHasColumns(dataTable);
    }


}
