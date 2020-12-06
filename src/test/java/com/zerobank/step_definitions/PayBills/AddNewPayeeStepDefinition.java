package com.zerobank.step_definitions.PayBills;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class AddNewPayeeStepDefinition {
    WebDriverWait wait = new WebDriverWait(Driver.get(), 20);
    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> dataTable) {
        int i = 0;
        for(Map.Entry<String, String> entry: dataTable.entrySet()){
            if(entry.getKey().toLowerCase().contains(payBillsPage.newPayeeFields.get(i).getAttribute("name").toLowerCase())){
                payBillsPage.newPayeeFields.get(i).sendKeys(entry.getValue());
                i++;
            }
        }
    }

    @Given("Click Add")
    public void click_Add() {
        payBillsPage.addButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        wait.until(ExpectedConditions.textToBePresentInElement(payBillsPage.alertMessage, message));

        Assert.assertEquals("Message is not displayed", payBillsPage.alertMessage.getText(), message);
        System.out.println("Alert message is displyed: "+payBillsPage.alertMessage.getText());
    }



}
