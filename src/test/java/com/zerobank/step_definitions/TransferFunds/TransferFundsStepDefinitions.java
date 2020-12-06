package com.zerobank.step_definitions.TransferFunds;

import com.zerobank.pages.TransferFundsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TransferFundsStepDefinitions {

    TransferFundsPage transferFundsPage = new TransferFundsPage();

    @Then("User verifies that following fields are displayed")
    public void user_verifies_that_following_fields_are_displayed(List<String> dataTable) {
        for(int i = 0; i<transferFundsPage.presentFields.size();i++){
            Assert.assertEquals(transferFundsPage.presentFields.get(i).getText(), dataTable.get(i));
        }
    }

    @Then("User verifies that From Account dropdown default option is {string}")
    public void user_verifies_that_From_Account_dropdown_default_option_is(String expected) {
      transferFundsPage.verifyDefaultValueDropdown(expected, transferFundsPage.fromAccountDropdown);

    }

    @Then("User verifies that To Account dropdown default option is {string}")
    public void user_verifies_that_To_Account_dropdown_default_option_is(String expected) {
        transferFundsPage.verifyDefaultValueDropdown(expected, transferFundsPage.toAccountDropdown);
    }

    @Then("User selects {string} from From Account dropdown")
    public void user_selects_from_From_Account_dropdown(String accountValue) {
        transferFundsPage.selectDropdown(transferFundsPage.fromAccountDropdown, accountValue);
    }
    @Then("User selects {string} from to Account dropdown")
    public void user_selects_from_to_Account_dropdown(String accountValue) {
        transferFundsPage.selectDropdown(transferFundsPage.toAccountDropdown, accountValue);
    }


    @Then("User enters amount {string} to Amount field on Transfer Funds Page")
    public void user_enters_amount_to_Amount_field_on_Transfer_Funds_Page(String amount) {
        transferFundsPage.amountBox.sendKeys(amount);
    }

    @Then("User enters {string} in Description field on Transfer Funds Page")
    public void user_enters_in_Description_field_on_Transfer_Funds_Page(String description) {
        transferFundsPage.descriptionBox.sendKeys(description);
    }

    @When("User clicks on Continue button on Transfer Funds Page")
    public void user_clicks_on_Continue_button_on_Transfer_Funds_Page() {
        transferFundsPage.continueButton.click();
    }

    @Then("User on the confirmation page and {string} is displayed")
    public void user_on_the_confirmation_page_and_is_displayed(String verifyMessage) {
        Assert.assertTrue("The Message is NOT displayed", transferFundsPage.verifyMessage.isDisplayed());
        Assert.assertEquals("The Message does not match", verifyMessage, transferFundsPage.verifyMessage.getText());
    }

    @When("User clicks Submit button on the Transfer Funds Page")
    public void user_clicks_Submit_button_on_the_Transfer_Funds_Page() {
        transferFundsPage.submitButton.click();
    }

    @Then("User verifies that confirmation message {string} is displayed on Transfer Funds Page")
    public void user_verifies_that_confirmation_message_is_displayed_on_Transfer_Funds_Page(String expectedMessage) {
        Assert.assertTrue("The Message is not displayed", transferFundsPage.confirmationMessage.isDisplayed());
        Assert.assertEquals("The Message does not match", expectedMessage, transferFundsPage.confirmationMessage.getText());
    }

}
