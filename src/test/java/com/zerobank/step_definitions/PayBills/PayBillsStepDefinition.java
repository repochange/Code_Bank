package com.zerobank.step_definitions.PayBills;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PayBillsStepDefinition {

    PayBillsPage payBillsPage = new PayBillsPage();

    @When("User navigates to the {string} page")
    public void user_navigates_to_the_page(String tabName) {
        payBillsPage.navigateTo(tabName);
        WebDriverWait webDriverWait = new WebDriverWait(Driver.get(), 10);
        webDriverWait.until(ExpectedConditions.titleIs(Driver.get().getTitle()));

    }


    @When("User completes successful Pay operation with following data")
    public void user_completes_successful_Pay_operation_with_following_data(List<String> dataTable) {
        payBillsPage.selectDropdownOptionByVisibleText(payBillsPage.payeeDropdown, dataTable.get(0));
        payBillsPage.selectDropdownOptionByVisibleText(payBillsPage.accountDropdown, dataTable.get(1));
        payBillsPage.amountField.sendKeys(dataTable.get(2));
        payBillsPage.dateField.sendKeys(dataTable.get(3));
        payBillsPage.descriptionField.sendKeys(dataTable.get(4));
        payBillsPage.payButton.click();

    }
    @Then("User verifies that confirmation message {string} is displayed")
    public void user_verifies_that_confirmation_message_is_displayed(String expectedConfirmationMessage) {
        Assert.assertEquals("Wrong message", expectedConfirmationMessage, payBillsPage.paymentConfirmationMessage.getText());
        Assert.assertTrue(payBillsPage.paymentConfirmationMessage.isDisplayed());
        System.out.println("Confirmation message is displayed");
    }
    @When("User doesn't fill the Amount field and clicks Pay")
    public void user_doesn_t_fill_the_Amount_field_and_clicks_Pay() {
        payBillsPage.paymentOperation("Apple", "Credit Card",
                "","2020-07-30","money");
        payBillsPage.payButton.click();
    }

    @Then("User verifies that warning message for Amount field {string} is appears")
    public void user_verifies_that_warning_message_for_Amount_field_is_appears(String expectedWarningMessage) {
        Assert.assertEquals("Warning message does Not appear", expectedWarningMessage,
                payBillsPage.amountField.getAttribute("validationMessage"));
    }
    @When("User doesn't fill the Date field and clicks Pay")
    public void user_doesn_t_fill_the_Date_field_and_clicks_Pay() {
        payBillsPage.paymentOperation("Apple", "Credit Card",
                "500","","money");
        payBillsPage.payButton.click();
    }

    @Then("User verifies that warning message for Data field {string} is appears")
    public void user_verifies_that_warning_message_for_Data_field_is_appears(String expectedWarningMessage) {
        Assert.assertEquals("Warning message does Not appear", expectedWarningMessage,
                payBillsPage.dateField.getAttribute("validationMessage"));
    }

    @Then("User fills all the fields properly but enters alphabetical or specials characters to the Amount field")
    public void user_fills_all_the_fields_properly_but_enters_alphabetical_or_specials_characters_to_the_Amount_field() {
        payBillsPage.paymentOperation("Apple", "Credit Card",
                "A_!k@#$","2020-07-30","money");
    }

    @Then("User clicks Pay and verifies that warning message for Amount field {string} is appears")
    public void user_clicks_Pay_and_verifies_that_warning_message_for_Amount_field_is_appears(String expectedWarningMessage) {
        payBillsPage.payButton.click();
        Assert.assertTrue("Warning message is not displayed! Alphabetical symbols are accepted", !payBillsPage.paymentConfirmationMessage.isDisplayed());
        Assert.assertEquals("Warning message does Not appear", expectedWarningMessage,
                payBillsPage.amountField.getAttribute("validationMessage"));
    }

    @Then("User fills all the fields properly but enters alphabetical or specials characters to the Date field")
    public void user_fills_all_the_fields_properly_but_enters_alphabetical_or_specials_characters_to_the_Date_field() {
        payBillsPage.paymentOperation("Apple", "Credit Card",
                "500","A_!k@#$","money789_!@#");
    }

    @Then("User clicks Pay and verifies that warning message for Data field {string} is appears")
    public void user_clicks_Pay_and_verifies_that_warning_message_for_Data_field_is_appears(String expectedWarningMessage) {
        payBillsPage.payButton.click();
        try {
            Assert.assertTrue("Warning message is not displayed! Alphabetical symbols are accepted", !payBillsPage.paymentConfirmationMessage.isDisplayed());
        }catch(Exception e){

        }
        Assert.assertEquals("Warning message does Not appear", expectedWarningMessage,
                payBillsPage.dateField.getAttribute("validationMessage"));
    }


}
