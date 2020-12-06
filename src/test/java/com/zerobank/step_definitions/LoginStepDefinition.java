package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {

    LoginPage lp = new LoginPage();


    @Given("User on the login page")
    public void user_on_the_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
        System.out.println("User on the login page");
        BrowserUtils.wait(1);
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {

        this.lp.login();
    }

    @Then("User verifies that {string} subtitle is displayed")
    public void user_verifies_that_subtitle_is_displayed(String loginSubtitle) {
        lp.verifySubtitle(loginSubtitle);
        //Assert.assertEquals("Wrong title", loginSubtitle, Driver.get().getTitle());
        System.out.println("User on the HomePage");
    }
    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        lp.loginWithInvalidCredentials(username, password);
        System.out.println(username);

    }

    @Then("User verifies that warning message {string} is displayed")
    public void user_verifies_that_warning_message_is_displayed(String warningMessage) {
        Assert.assertTrue(lp.warningMessage.isDisplayed());
        Assert.assertEquals("Wrong warning message",warningMessage, lp.warningMessage.getText());
    }


}