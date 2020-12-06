$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/TransferFunds/TransferFunds.feature");
formatter.feature({
  "name": "Transfer Funds",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Regression"
    },
    {
      "name": "@TransferFunds"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User on the Home page",
  "keyword": "Given "
});
formatter.match({
  "location": "AccountActivityStepDefinition.user_on_the_Home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to the \"Transfer Funds\" page",
  "keyword": "When "
});
formatter.match({
  "location": "PayBillsStepDefinition.user_navigates_to_the_page(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check transfer feature. Transfer money from Brokerage account to Loan",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Regression"
    },
    {
      "name": "@TransferFunds"
    },
    {
      "name": "@TransferFunds1"
    }
  ]
});
formatter.step({
  "name": "User selects \"Brokerage 6\" from From Account dropdown",
  "keyword": "Then "
});
formatter.match({
  "location": "TransferFundsStepDefinitions.user_selects_from_From_Account_dropdown(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects \"Loan 4\" from to Account dropdown",
  "keyword": "And "
});
formatter.match({
  "location": "TransferFundsStepDefinitions.user_selects_from_to_Account_dropdown(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters amount \"80\" to Amount field on Transfer Funds Page",
  "keyword": "Then "
});
formatter.match({
  "location": "TransferFundsStepDefinitions.user_enters_amount_to_Amount_field_on_Transfer_Funds_Page(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"Payment\" in Description field on Transfer Funds Page",
  "keyword": "And "
});
formatter.match({
  "location": "TransferFundsStepDefinitions.user_enters_in_Description_field_on_Transfer_Funds_Page(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Continue button on Transfer Funds Page",
  "keyword": "When "
});
formatter.match({
  "location": "TransferFundsStepDefinitions.user_clicks_on_Continue_button_on_Transfer_Funds_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User on the confirmation page and \"Please verify that the following transaction is correct by selecting the Submit button below.\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "TransferFundsStepDefinitions.user_on_the_confirmation_page_and_is_displayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks Submit button on the Transfer Funds Page",
  "keyword": "When "
});
formatter.match({
  "location": "TransferFundsStepDefinitions.user_clicks_Submit_button_on_the_Transfer_Funds_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies that confirmation message \"You successfully submitted your transaction.\" is displayed on Transfer Funds Page",
  "keyword": "Then "
});
formatter.match({
  "location": "TransferFundsStepDefinitions.user_verifies_that_confirmation_message_is_displayed_on_Transfer_Funds_Page(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});