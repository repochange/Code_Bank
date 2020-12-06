package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "user_login")
    public WebElement username;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement submitButton;

    @FindBy(css = "div[class = 'alert alert-error']")
    public WebElement warningMessage;



    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public void login(){
        this.username.sendKeys(System.getProperty("Username"));
        this.password.sendKeys(System.getProperty("Password"));
        submitButton.click();
    }

    public void loginWithInvalidCredentials(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        submitButton.click();
    }





}
