package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TransferFundsPage extends BasePage{

    @FindBy(css = "select[id='tf_fromAccountId']")
    public WebElement fromAccountDropdown;

    @FindBy(css = "select[id='tf_toAccountId']")
    public WebElement toAccountDropdown;

    @FindBy(css = "label[class='control-label']")
    public List<WebElement> presentFields;

    @FindBy(css = "input[name='amount']")
    public WebElement amountBox;

    @FindBy(css = "input[name='description']")
    public WebElement descriptionBox;

    @FindBy(css = "button[type='submit']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[contains(text(), 'Please verify')]")
    public WebElement verifyMessage;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    @FindBy(css = "div[class='alert alert-success']")
    public WebElement confirmationMessage;

    public TransferFundsPage(){
        PageFactory.initElements(Driver.get(), this);

    }
}
