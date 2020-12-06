package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayBillsPage extends BasePage {

    @FindBy(name = "payee")
    public WebElement payeeDropdown;

    @FindBy(name = "account")
    public WebElement accountDropdown;

    @FindBy(name = "amount")
    public WebElement amountField;

    @FindBy(name = "date")
    public WebElement dateField;

    @FindBy(name = "description")
    public WebElement descriptionField;

    @FindBy(css = "input[value = 'Pay']")
    public WebElement payButton;

    @FindBy(xpath = "//span[text()[contains(., 'The payment was ')]]")
    public WebElement paymentConfirmationMessage;

    @FindBy(xpath = "//*[contains(@id,'np_new_payee_')]")
    public List<WebElement> newPayeeFields;                     //Name, Address, Account,Details

    @FindBy(css = "input[value='Add']")
    public WebElement addButton;

    @FindBy(css = "div[id='alert_content']")
    public WebElement alertMessage;

    @FindBy(css = "select[name='currency']")
    public WebElement currencyDropdown;

    @FindBy(css = "input[type='button']")
    public WebElement calculateCurrency;


    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    public void paymentOperation(String payeeDropdownVsblText, String accountDropDownVsblText, String amount,
                                 String dateYYYY_MM_DD, String description  ){
        selectDropdownOptionByVisibleText(this.payeeDropdown,payeeDropdownVsblText);
        selectDropdownOptionByVisibleText(this.accountDropdown, accountDropDownVsblText);
        amountField.sendKeys(amount);
        dateField.sendKeys(dateYYYY_MM_DD);
        descriptionField.sendKeys(description);
    }



}
