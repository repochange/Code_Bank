package com.zerobank.step_definitions.PayBills;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.omg.PortableInterceptor.ACTIVE;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyStepDefinition {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        Select select = new Select(payBillsPage.currencyDropdown);
        List<WebElement> dropdownElements = select.getOptions();
        List<String> actual=new ArrayList<>();
        dropdownElements.forEach(each->{if(!each.getText().equals("Select One")){actual.add(each.getText());}});
        Assert.assertEquals("List of values doesn't match", dataTable, actual);
    }

    @When("User tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.calculateCurrency.click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
       Alert alert =Driver.get().switchTo().alert();
       Assert.assertEquals("Message is NOT displayed", "Please, ensure that you have filled all the required fields with valid values.", alert.getText() );
        System.out.println("Message is displayed: "+alert.getText());
    }

    @When("User tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        payBillsPage.calculateCurrency.click();
    }

}
